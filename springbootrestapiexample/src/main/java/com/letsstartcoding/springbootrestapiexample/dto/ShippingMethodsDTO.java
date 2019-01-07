package com.letsstartcoding.springbootrestapiexample.dto;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="trn_shipping_methods")
@EntityListeners(AuditingEntityListener.class)
public class ShippingMethodsDTO implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "SHIPPING_METHOD_ID")
    private int shippingMethodId;
    @Column(name = "SHIPPING_METHOD")
    private String shippingMethod;

    @OneToMany(mappedBy = "shippingMethodsDTO",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrdersDTO> ordersShipping;



    public ShippingMethodsDTO() {

    }

    public ShippingMethodsDTO(String shippingMethod,List<OrdersDTO> ordersShipping) {
        this.shippingMethod = shippingMethod;
        this.ordersShipping = ordersShipping;

    }

    public int getShippingMethodId() {
        return shippingMethodId;
    }

    public ShippingMethodsDTO setShippingMethodId(int shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
        return this;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public ShippingMethodsDTO setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
        return this;
    }

    public List<OrdersDTO> getOrdersShipping() {
        return ordersShipping;
    }

    public void setOrdersShipping(List<OrdersDTO> ordersShipping) {
        this.ordersShipping = ordersShipping;
    }

    @Override
    public String toString() {
        return "ShippingMethodsDTO{" +
                "shippingMethodId=" + shippingMethodId +
                ", shippingMethod='" + shippingMethod + '\'' +
                '}';
    }
}
