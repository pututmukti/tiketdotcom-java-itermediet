package com.letsstartcoding.springbootrestapiexample.controller;

import com.letsstartcoding.springbootrestapiexample.dao.ShippingMethodsDAO;
import com.letsstartcoding.springbootrestapiexample.dto.EmployeeDTO;
import com.letsstartcoding.springbootrestapiexample.dto.ShippingMethodsDTO;
import com.letsstartcoding.springbootrestapiexample.repository.ShippingMethodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/API")
public class MethodShippingController {
    @Autowired
    ShippingMethodsDAO shippingMethodsDAO;

    @GetMapping(path="/getAllShippingMethods")
    public List<ShippingMethodsDTO> getAllShippingMethods(){
        List<ShippingMethodsDTO>  shippingList = shippingMethodsDAO.findAll();
        return shippingList;
    }
}
