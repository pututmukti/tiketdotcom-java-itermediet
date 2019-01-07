package com.letsstartcoding.springbootrestapiexample.repository;

import com.letsstartcoding.springbootrestapiexample.dto.OrderDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsDTO,Integer> {
}
