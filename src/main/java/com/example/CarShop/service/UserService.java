package com.example.CarShop.service;

import com.example.CarShop.dto.UserDto;
import com.example.CarShop.form.UserCreateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    Page<UserDto> findAll(Pageable pageable);
    UserDto create(UserCreateForm form);

    void deleteById(Long id);




}
