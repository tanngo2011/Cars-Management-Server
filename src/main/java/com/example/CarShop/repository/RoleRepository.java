package com.example.CarShop.repository;

import com.example.CarShop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Type;

public interface RoleRepository extends JpaRepository<Role, Long> {


    Role findByType(Role.Type type);
}
