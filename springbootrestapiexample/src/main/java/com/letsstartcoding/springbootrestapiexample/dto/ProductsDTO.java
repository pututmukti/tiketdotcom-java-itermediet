package com.letsstartcoding.springbootrestapiexample.dto;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="trn_products")
@EntityListeners(AuditingEntityListener.class)
public class ProductsDTO implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private int productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "UNIT_PRICE")
    private int unitPrice;
    @Column(name = "IN_STOCK")
    private char inStock;

    @OneToMany( mappedBy = "products",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderDetailsDTO> orderDetailsCustomer;


    public ProductsDTO(){

    }

    public ProductsDTO(String productName, int unitPrice, char inStock,List<OrderDetailsDTO> orderDetailsCustomer) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.inStock = inStock;
        this.orderDetailsCustomer = orderDetailsCustomer;

    }

    public List<OrderDetailsDTO> getOrderDetailsCustomer() {
        return orderDetailsCustomer;
    }

    public void setOrderDetailsCustomer(List<OrderDetailsDTO> orderDetailsCustomer) {
        this.orderDetailsCustomer = orderDetailsCustomer;
    }

    public int getProductId() {
        return productId;
    }

    public ProductsDTO setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public ProductsDTO setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public char getInStock() {
        return inStock;
    }

    public void setInStock(char inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "ProductsDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", inStock=" + inStock +
                '}';
    }
}
