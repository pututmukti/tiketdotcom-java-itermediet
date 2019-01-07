package com.letsstartcoding.springbootrestapiexample.repository;

import com.letsstartcoding.springbootrestapiexample.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Integer> {


}