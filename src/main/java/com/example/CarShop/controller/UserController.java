package com.example.CarShop.controller;

import com.example.CarShop.dto.UserDto;
import com.example.CarShop.form.UserCreateForm;
import com.example.CarShop.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/api/v1/login")
    public ResponseEntity<Map<String,String>> login(){
            Map<String,String> response = new HashMap<>();
            response.put("message: ","Đăng nhập thành công!!!");
            response.put("username: ", "hh");
            return ResponseEntity.ok(response);
    }

    @PostMapping("/api/v1/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody @Valid UserCreateForm form) {
        return userService.create(form);
    }


    @GetMapping("/api/v1/users")
    @ResponseStatus(HttpStatus.OK)
    public Page<UserDto> findAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @DeleteMapping("/api/v1/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){userService.deleteById(id);
    }

}
