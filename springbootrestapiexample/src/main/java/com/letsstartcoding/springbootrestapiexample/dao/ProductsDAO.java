package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.dto.ProductsDTO;
import com.letsstartcoding.springbootrestapiexample.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsDAO {
    @Autowired
    ProductsRepository productsRepository;

    public ProductsDTO save(ProductsDTO products) {
        return productsRepository.save(products);
    }

}
