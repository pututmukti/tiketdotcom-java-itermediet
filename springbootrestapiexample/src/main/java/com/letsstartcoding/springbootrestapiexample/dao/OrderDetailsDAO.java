package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.dto.OrderDetailsDTO;
import com.letsstartcoding.springbootrestapiexample.repository.OrderDetailsRepository;
import com.letsstartcoding.springbootrestapiexample.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsDAO {
    @Autowired
     OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsDTO save(OrderDetailsDTO orderDetailsDTO){return orderDetailsRepository.save(orderDetailsDTO);}

}
