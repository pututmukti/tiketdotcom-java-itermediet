package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.dto.OrdersDTO;
import com.letsstartcoding.springbootrestapiexample.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersDAO {
    @Autowired
    OrdersRepository ordersRepository;

    public OrdersDTO save(OrdersDTO ordersDTO){return ordersRepository.save(ordersDTO);}
}
