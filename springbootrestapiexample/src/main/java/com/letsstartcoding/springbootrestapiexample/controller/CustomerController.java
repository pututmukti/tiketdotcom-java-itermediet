package com.letsstartcoding.springbootrestapiexample.controller;

import com.letsstartcoding.springbootrestapiexample.dao.CustomerDAO;
import com.letsstartcoding.springbootrestapiexample.dto.CustomerDTO;
import com.letsstartcoding.springbootrestapiexample.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/API")
public class CustomerController {
    @Autowired
    CustomerDAO customerDAO;

    @GetMapping(path="/getAllCustomer")
    public List<CustomerDTO> getAllCustomer(){
        return customerDAO.findAll();
    }
}
