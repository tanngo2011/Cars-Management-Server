package com.example.CarShop.controller;

import com.example.CarShop.dto.AccessoryDto;
import com.example.CarShop.form.AccessoryCreateForm;
import com.example.CarShop.form.AccessoryUpdateForm;
import com.example.CarShop.service.AccessoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class AccessoryController {

    private final AccessoryService accessoryService;


    @GetMapping("/api/v1/accessories")
    public Page<AccessoryDto> findAll(Pageable pageable){
        return accessoryService.findAll(pageable);
    }


    @PostMapping("/api/v1/accessories")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessoryDto create(@RequestBody @Valid AccessoryCreateForm form) {
        return accessoryService.create(form);
    }


    @PutMapping("/api/v1/accessories/{id}")
    public AccessoryDto update(
            @RequestBody @Valid AccessoryUpdateForm form,
            @PathVariable("id") Long id
    ) {
        return accessoryService.update(form, id);
    }


    @DeleteMapping("/api/v1/accessories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
        accessoryService.deleteById(id);
    }
}
