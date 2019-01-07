package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import com.letsstartcoding.springbootrestapiexample.dto.EmployeeDTO;
import com.letsstartcoding.springbootrestapiexample.dto.OrdersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.Query;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.letsstartcoding.springbootrestapiexample.repository.EmployeeRepository;


@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;

	
	/*to save an employee*/
	
	public EmployeeDTO save(EmployeeDTO emp) {
		return employeeRepository.save(emp);
	}

	public List<EmployeeDTO> findAll(){
		return employeeRepository.findAll();
	}

    public List<EmployeeDTO> findEmployeeHaveCustomer(){
		OrdersDTO ordersDTO = new OrdersDTO();


       // return employeeRepository.fetchEmpHaveOrder();
		  return null;
    }

	

}
