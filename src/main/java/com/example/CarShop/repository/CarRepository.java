package com.example.CarShop.repository;

import com.example.CarShop.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarRepository extends
        JpaRepository<Car, Car.PrimaryKey>,
        JpaSpecificationExecutor<Car> {

}
