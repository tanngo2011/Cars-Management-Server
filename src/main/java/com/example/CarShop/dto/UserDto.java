package com.example.CarShop.dto;

import com.example.CarShop.entity.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class UserDto {

    private Long id;

    private String fullname;

    private Set<Role> roles;
}
