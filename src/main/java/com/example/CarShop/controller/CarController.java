package com.example.CarShop.controller;


import com.example.CarShop.dto.CarDto;
import com.example.CarShop.entity.Car;
import com.example.CarShop.form.CarCreateForm;
import com.example.CarShop.form.CarFilterForm;
import com.example.CarShop.form.CarUpdateForm;
import com.example.CarShop.service.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@CrossOrigin("*")

public class CarController {
    private final CarService carService;


    @PostMapping("/api/v1/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto create(@RequestBody @Valid CarCreateForm form) {
        return carService.create(form);
    }


    @GetMapping("/api/v1/allcars")
    public Page<CarDto> findAllPage(){
        return carService.findAllPage();
    }

    @GetMapping("/api/v1/cars")
    public Page<CarDto> findAll(CarFilterForm form, Pageable pageable){
        return carService.findAll(form, pageable);
    }


    @PutMapping("/api/v1/cars")
    public CarDto update(@RequestBody @Valid CarUpdateForm form){
        return carService.update(form);
    }


    @DeleteMapping("/api/v1/cars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestBody Car.PrimaryKey pk){
        carService.deleteById(pk);
    }



}
