package com.letsstartcoding.springbootrestapiexample.dto;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="trn_orders")
@EntityListeners(AuditingEntityListener.class)
public class OrdersDTO implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private int orderId;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "PURCHASE_ORDER_NUMBER")
    private String purchaseOrderNumber;
    @Column(name = "SHIP_DATE")
    private Date shipDate;
    @Column(name = "FREIGHT_CHARGE")
    private int freightCharge;
    @Column(name = "TAXES")
    private int taxes;
    @Column(name = "PAYMENT_RECEIVED")
    private char paymentReceived;
    @Column(name = "COMMENT")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", nullable=true)
    private CustomerDTO customers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", nullable=true)
    private EmployeeDTO employees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHIPPING_METHOD_ID", nullable=true)
    private ShippingMethodsDTO shippingMethodsDTO;

    @OneToMany( mappedBy = "orders",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderDetailsDTO> orderDetailsOrders;


    public List<OrderDetailsDTO> getOrderDetailsOrders() {
        return orderDetailsOrders;
    }

    public void setOrderDetailsOrders(List<OrderDetailsDTO> orderDetailsOrders) {
        this.orderDetailsOrders = orderDetailsOrders;
    }


    public OrdersDTO(){

    }


    public OrdersDTO(Date orderDate, String purchaseOrderNumber, Date shipDate, int freightCharge, int taxes, char paymentReceived, String comment, CustomerDTO customers, EmployeeDTO employees, ShippingMethodsDTO shippingMethodsDTO,List<OrderDetailsDTO> orderDetailsOrders) {

        this.orderDate = orderDate;
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.shipDate = shipDate;
        this.freightCharge = freightCharge;
        this.taxes = taxes;
        this.paymentReceived = paymentReceived;
        this.comment = comment;
        this.customers = customers;
        this.employees = employees;
        this.shippingMethodsDTO = shippingMethodsDTO;
        this.orderDetailsOrders = orderDetailsOrders;
    }

    //getter method to retrieve the AuthorId
    public int getCustomer_id(){
        return customers.getCustomerId();
    }

    public int getEmployee_id(){
        return employees.getEmployeeId();
    }

    public int getShippingMethods_id(){
        return shippingMethodsDTO.getShippingMethodId();
    }

    public int getOrderId() {
        return orderId;
    }

    public OrdersDTO setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }



    public Date getOrderDate() {
        return orderDate;
    }

    public OrdersDTO setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public OrdersDTO setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
        return this;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }


    public int getFreightCharge() {
        return freightCharge;
    }

    public void setFreightCharge(int freightCharge) {
        this.freightCharge = freightCharge;
    }

    public int getTaxes() {
        return taxes;
    }

    public void setTaxes(int taxes) {
        this.taxes = taxes;
    }

    public char getPaymentReceived() {
        return paymentReceived;
    }

    public void setPaymentReceived(char paymentReceived) {
        this.paymentReceived = paymentReceived;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CustomerDTO getCustomers() {
        return customers;
    }

    public void setCustomers(CustomerDTO customers) {
        this.customers = customers;
    }

    public EmployeeDTO getEmployees() {
        return employees;
    }

    public void setEmployees(EmployeeDTO employees) {
        this.employees = employees;
    }

    public ShippingMethodsDTO getShippingMethodsDTO() {
        return shippingMethodsDTO;
    }

    public void setShippingMethodsDTO(ShippingMethodsDTO shippingMethodsDTO) {
        this.shippingMethodsDTO = shippingMethodsDTO;
    }


}
