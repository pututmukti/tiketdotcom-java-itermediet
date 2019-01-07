package com.letsstartcoding.springbootrestapiexample.repository;

import com.letsstartcoding.springbootrestapiexample.dto.ShippingMethodsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingMethodsRepository extends JpaRepository<ShippingMethodsDTO,Integer> {
}
