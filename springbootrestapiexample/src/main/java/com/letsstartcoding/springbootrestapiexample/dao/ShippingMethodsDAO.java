package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.dto.EmployeeDTO;
import com.letsstartcoding.springbootrestapiexample.dto.ShippingMethodsDTO;
import com.letsstartcoding.springbootrestapiexample.repository.ShippingMethodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingMethodsDAO {
    @Autowired
    ShippingMethodsRepository shippingMethodsRepository;

    public ShippingMethodsDTO save(ShippingMethodsDTO shippingMethodsDTO){return shippingMethodsRepository.save(shippingMethodsDTO);}

    public List<ShippingMethodsDTO> findAll(){
        return shippingMethodsRepository.findAll();
    }
}
