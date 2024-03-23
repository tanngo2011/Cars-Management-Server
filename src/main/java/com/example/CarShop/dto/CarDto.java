package com.example.CarShop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CarDto {

    @JsonProperty("licensePlate")
    private String pkLicensePlate;
    @JsonProperty("repairDate")
    private LocalDate pkRepairDate;
    private String customerName;
    private String catalog;
    private String carMaker;
}
