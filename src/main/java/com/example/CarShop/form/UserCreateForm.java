package com.example.CarShop.form;

import com.example.CarShop.entity.Car;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Getter
@Setter
public class UserCreateForm {

    @NotBlank
    @Length(max = 255)
    private String fullname;

    @NotBlank
    @Length(max = 255)
    private String username;

    @NotBlank
    @Length(max = 255)
    private String password;

}
