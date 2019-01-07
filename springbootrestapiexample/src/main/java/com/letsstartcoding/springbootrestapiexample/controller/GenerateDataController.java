package com.letsstartcoding.springbootrestapiexample.controller;

import com.letsstartcoding.springbootrestapiexample.dao.CustomerDAO;
import com.letsstartcoding.springbootrestapiexample.dao.EmployeeDAO;
import com.letsstartcoding.springbootrestapiexample.dao.ProductsDAO;
import com.letsstartcoding.springbootrestapiexample.dto.*;
import com.letsstartcoding.springbootrestapiexample.repository.OrderDetailsRepository;
import com.letsstartcoding.springbootrestapiexample.repository.OrdersRepository;
import com.letsstartcoding.springbootrestapiexample.repository.ShippingMethodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/API")
public class GenerateDataController {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    ProductsDAO productsDAO;

    @Autowired
    ShippingMethodsRepository shippingMethodsRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @GetMapping(path="/customers")
    public String saveCustomer(){
        String csvFile = "src/main/resources/templates/Customers.csv";;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int header = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] customer = line.split(cvsSplitBy);
                CustomerDTO customerDTO = new CustomerDTO();


                if(header > 0) {
                    customerDTO.setCompanyName(customer[1]);
                    customerDTO.setFirstName(customer[2]);
                    customerDTO.setLastName(customer[3]);
                    customerDTO.setBillingAddress(customer[4]);
                    customerDTO.setCity(customer[5]);
                    customerDTO.setStateOrProvince(customer[6]);
                    customerDTO.setZipCode(customer[7]);
                    customerDTO.setEmail(customer[8]);
                    customerDTO.setCompanyName(customer[9]);
                    customerDTO.setPhoneNumber(customer[10]);
                    customerDTO.setFaxNumber(customer[11]);
                    customerDTO.setShipAddress(customer[12]);
                    customerDTO.setShipCity(customer[13]);
                    customerDTO.setShipPhoneNumber(customer[14]);

                    //customerServices.saveCustomer(customerDTO);
                    customerDAO.save(customerDTO);

                }

                header++;


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "hello customers";
    }

    @GetMapping(path="/employee")
    public String saveEmployee(){
        String csvFile = "src/main/resources/templates/Employees.csv";;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int header = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] employees = line.split(cvsSplitBy);
                EmployeeDTO employeeDTO = new EmployeeDTO();


                if(header > 0) {

                    employeeDTO.setFirstName(employees[1]);
                    employeeDTO.setLastName(employees[2]);
                    employeeDTO.setTitle(employees[3]);
                    employeeDTO.setWorkPhone(employees[4]);

                    //customerServices.saveCustomer(customerDTO);
                    employeeDAO.save(employeeDTO);

                }

                header++;


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "hello employees";
    }

    @GetMapping(path="/products")
    public String saveProducts(){
        String csvFile = "src/main/resources/templates/Products.csv";;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int header = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] products = line.split(cvsSplitBy);
                ProductsDTO productsDTO = new ProductsDTO();


                if(header > 0) {

                    productsDTO.setProductName(products[1]);
                    productsDTO.setUnitPrice(Integer.parseInt(products[2]));
                    char stok = products[3].charAt(0);
                    productsDTO.setInStock(stok);

                    //customerServices.saveCustomer(customerDTO);
                    productsDAO.save(productsDTO);

                }

                header++;


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "hello Products";
    }

    @GetMapping(path="/shippingMethods")
    public String saveShippingMethods(){
        String csvFile = "src/main/resources/templates/ShippingMethods.csv";;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int header = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] shippingMethods = line.split(cvsSplitBy);
                ShippingMethodsDTO shippingMethodsDTO = new ShippingMethodsDTO();


                if(header > 0) {

                    shippingMethodsDTO.setShippingMethod(shippingMethods[1]);

                    shippingMethodsRepository.save(shippingMethodsDTO);

                }

                header++;


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "hello_Shipping_Methods";
    }


    @GetMapping(path="/orders")
    public String saveOrders(){
        String csvFile = "src/main/resources/templates/Orders.csv";;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        CustomerDTO customerDTO = new CustomerDTO();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        ShippingMethodsDTO shippingMethodsDTO = new ShippingMethodsDTO();


        try {

            br = new BufferedReader(new FileReader(csvFile));
            int header = 0;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] ordersList = line.split(cvsSplitBy);
                OrdersDTO ordersDTO = new OrdersDTO();


                if(header > 0) {

                    ordersDTO.setCustomers(customerDTO.setCustomerId(Integer.parseInt(ordersList[1])));
                    ordersDTO.setEmployees(employeeDTO.setEmployeeId(Integer.parseInt(ordersList[2])));


                    //convert String to LocalDate
                    ordersDTO.setOrderDate(dateFormat.parse(ordersList[3]));

                    ordersDTO.setPurchaseOrderNumber(ordersList[4]);


                    ordersDTO.setShipDate(dateFormat.parse(ordersList[5]));
                    ordersDTO.setShippingMethodsDTO(shippingMethodsDTO.setShippingMethodId(Integer.parseInt(ordersList[6])));
                    ordersDTO.setFreightCharge(0);
                    ordersDTO.setTaxes((ordersList[8] != null) ? Integer.parseInt(ordersList[8]) : 0 );
                    ordersDTO.setPaymentReceived(ordersList[9].charAt(0));
                    ordersDTO.setComment("");

                    ordersRepository.save(ordersDTO);

                }

                header++;


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "hello_Shipping_Methods";
    }


    @GetMapping(path="/orderDetails")
    public String saveOrderDetail(){
        String csvFile = "src/main/resources/templates/OrderDetails.csv";;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        ProductsDTO products =  new ProductsDTO();
        OrdersDTO ordersDTO = new OrdersDTO();


        try {

            br = new BufferedReader(new FileReader(csvFile));
            int header = 0;

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] orderDetailList = line.split(cvsSplitBy);
                OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();


                if(header > 0) {

                    orderDetailsDTO.setProducts(products.setProductId(Integer.parseInt(orderDetailList[2])));
                    orderDetailsDTO.setOrders(ordersDTO.setOrderId((Integer.parseInt(orderDetailList[1]))));
                    orderDetailsDTO.setQuantity(Integer.parseInt(orderDetailList[3]));
                    orderDetailsDTO.setDiscount(Integer.parseInt(orderDetailList[4]));
                    orderDetailsDTO.setUnitPrice(Integer.parseInt(orderDetailList[5]));

                    orderDetailsRepository.save(orderDetailsDTO);

                }

                header++;


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "hello_Oreder Detail";
    }

}
