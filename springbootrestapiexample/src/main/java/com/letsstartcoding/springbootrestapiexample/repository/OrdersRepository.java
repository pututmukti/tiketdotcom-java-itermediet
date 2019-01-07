package com.letsstartcoding.springbootrestapiexample.repository;

import com.letsstartcoding.springbootrestapiexample.dto.OrdersDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersDTO,Integer> {
}
