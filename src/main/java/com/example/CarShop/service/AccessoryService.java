package com.example.CarShop.service;

import com.example.CarShop.dto.AccessoryDto;
import com.example.CarShop.entity.Accessory;
import com.example.CarShop.form.AccessoryCreateForm;
import com.example.CarShop.form.AccessoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface AccessoryService {
    AccessoryDto create(AccessoryCreateForm form);

    Page<AccessoryDto> findAll(Pageable pageable);

    AccessoryDto update(AccessoryUpdateForm form, Long id);

    void deleteById(Long id);


}
