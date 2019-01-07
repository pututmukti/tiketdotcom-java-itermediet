package com.letsstartcoding.springbootrestapiexample.repository;

import com.letsstartcoding.springbootrestapiexample.dto.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDTO,Integer> {
}
