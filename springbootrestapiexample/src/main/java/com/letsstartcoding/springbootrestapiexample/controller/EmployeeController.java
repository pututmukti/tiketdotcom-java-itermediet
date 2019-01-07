package com.letsstartcoding.springbootrestapiexample.controller;

import com.letsstartcoding.springbootrestapiexample.dao.EmployeeDAO;
import com.letsstartcoding.springbootrestapiexample.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/API")
public class EmployeeController {

    @Autowired
    EmployeeDAO employeeDAO;

    @GetMapping(path="/getAllEmployee")
    public List<EmployeeDTO> getAllEmployee(){
         List<EmployeeDTO>  empList = employeeDAO.findAll();
         return empList;
    }

    @GetMapping(path="/getAllEmployeeHaveCustomer")
    public List<EmployeeDTO> getAllEmployeeHaveCustomer(){
        List<EmployeeDTO>  empList = employeeDAO.findAll();
        return empList;
    }

}
