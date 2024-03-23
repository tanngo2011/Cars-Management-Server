package com.example.CarShop.service;

import com.example.CarShop.dto.CarDto;
import com.example.CarShop.entity.Car;
import com.example.CarShop.form.CarCreateForm;
import com.example.CarShop.form.CarFilterForm;
import com.example.CarShop.form.CarUpdateForm;
import com.example.CarShop.repository.CarRepository;
import com.example.CarShop.specification.CarSpecification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor //--> sinh ra Constructor có đủ tham số, đã bao gồm @Autowired
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;


    @Override
    public CarDto create(CarCreateForm form) {
        var car = modelMapper.map(form, Car.class);
        var pk = modelMapper.map(form, Car.PrimaryKey.class);
        var carById = carRepository.findById(pk).orElse(null);
        if (carById != null) {
            throw new RuntimeException("Car đã tồn tại");
        }
        car.setPk(pk);
        var savedCar = carRepository.save(car);
        return modelMapper.map(savedCar, CarDto.class);
    }



    @Override
    public Page<CarDto> findAll(CarFilterForm form, Pageable pageable) {
        Specification<Car> spec = CarSpecification.buildSpec(form);
        return carRepository.findAll(spec, pageable).map(
                car -> modelMapper.map(car, CarDto.class));
    }


    @Override
    public Page<CarDto> findAllPage() {
        Pageable wholePage = Pageable.unpaged();
        return carRepository.findAll(wholePage).map(
                car -> modelMapper.map(car, CarDto.class));
    }




    @Override
    public CarDto update(CarUpdateForm form) {
//        var car = modelMapper.map(form, Car.class);
        var pk = modelMapper.map(form, Car.PrimaryKey.class);
        var car = carRepository.findById(pk).get();
        modelMapper.map(form,car);
        var savedCar = carRepository.save(car);
        return modelMapper.map(savedCar, CarDto.class);
    }


    @Override
    public void deleteById(Car.PrimaryKey pk) {
        carRepository.deleteById(pk);

    }
}
