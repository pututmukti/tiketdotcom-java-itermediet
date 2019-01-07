package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.dto.CustomerDTO;
import com.letsstartcoding.springbootrestapiexample.dto.EmployeeDTO;
import com.letsstartcoding.springbootrestapiexample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDAO {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerDTO save(CustomerDTO customerDTO){ return customerRepository.save(customerDTO); }

    public List<CustomerDTO> findAll(){
        return customerRepository.findAll();
    }




}
