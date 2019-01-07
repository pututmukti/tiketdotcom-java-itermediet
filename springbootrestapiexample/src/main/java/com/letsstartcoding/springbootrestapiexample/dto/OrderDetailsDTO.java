package com.letsstartcoding.springbootrestapiexample.dto;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="trn_order_details")
@EntityListeners(AuditingEntityListener.class)
public class OrderDetailsDTO implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ORDER_DETAIL_ID")
    private int orderDetailId;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "UNIT_PRICE")
    private int unitPrice;
    @Column(name = "DISCOUNT")
    private int discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable=true)
    private ProductsDTO products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable=true)
    private OrdersDTO orders;

    public OrderDetailsDTO(){

    }

    public OrderDetailsDTO( int unitPrice, int discount, ProductsDTO products,int quantity, OrdersDTO orders) {

        this.unitPrice = unitPrice;
        this.discount = discount;
        this.products = products;
        this.orders = orders;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public ProductsDTO getProducts() {
        return products;
    }

    public void setProducts(ProductsDTO products) {
        this.products = products;
    }

    public OrdersDTO getOrders() {
        return orders;
    }

    public void setOrders(OrdersDTO orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "orderDetailId=" + orderDetailId +
                ", unitPrice=" + unitPrice +
                ", discount=" + discount +
                ", products=" + products +
                ", orders=" + orders +
                '}';
    }
}
