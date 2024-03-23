package com.example.CarShop.form;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryCreateForm {

    //@NotNull: not null
    //@NotEmpty: not null + length > 0
    //@NotBlank: not null + length > 0 + phải có ký tự


    @NotBlank
    @Length(max = 255)
    private String name;

    @NotNull
    @PositiveOrZero
    private Long price;

    @NotNull
    @Length(max = 255)
    private String statusDamaged;

    @NotNull
    @Length(max = 255)
    private String repairStatus;

    @NotNull
    @Length(max = 255)
    private String licensePlate;

    @NotNull
    @PastOrPresent
    private LocalDate repairDate;
}
