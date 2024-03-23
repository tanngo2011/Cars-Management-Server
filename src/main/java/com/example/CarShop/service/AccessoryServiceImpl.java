package com.example.CarShop.service;

import com.example.CarShop.dto.AccessoryDto;
import com.example.CarShop.entity.Accessory;
import com.example.CarShop.entity.Car;
import com.example.CarShop.form.AccessoryCreateForm;
import com.example.CarShop.form.AccessoryUpdateForm;
import com.example.CarShop.repository.AccessoryRepository;
import com.example.CarShop.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LongSummaryStatistics;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AccessoryServiceImpl implements AccessoryService{

    private final AccessoryRepository accessoryRepository;

    private final CarRepository carRepository;

    private final ModelMapper modelMapper;

    @Override
    public AccessoryDto create(AccessoryCreateForm form) {

        Accessory accessory = modelMapper.map(form, Accessory.class);
        Car.PrimaryKey pk = modelMapper.map(form, Car.PrimaryKey.class);
//        Car car = carRepository.findById(pk).orElse(null);
//        if (!Objects.isNull(car)) {
//            accessory.setCar(car);
//        }
        Car car = carRepository.findById(pk).get();
        accessory.setCar(car);
        Accessory savedAccessory = accessoryRepository.save(accessory);

        return modelMapper.map(savedAccessory, AccessoryDto.class);
    }


    @Override
    public Page<AccessoryDto> findAll(Pageable pageable) {
        return accessoryRepository.findAll(pageable)
                .map(accessory -> modelMapper.map(accessory, AccessoryDto.class));
    }


    @Override
    public AccessoryDto update(AccessoryUpdateForm form, Long id) {
        Accessory accessory = accessoryRepository.findById(id).get();
        modelMapper.map(form, accessory);
        Accessory savedAccessory = accessoryRepository.save(accessory);
        return modelMapper.map(savedAccessory, AccessoryDto.class);
    }

    @Override
    public void deleteById(Long id) {
        accessoryRepository.deleteById(id);
    }
}
