package com.letsstartcoding.springbootrestapiexample.dto;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



import javax.persistence.*;

@Entity
@Table(name="trn_customers")
@EntityListeners(AuditingEntityListener.class)
public class CustomerDTO implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private int customerId;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "BILLING_ADDRESS")
    private String billingAddress;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATED_OR_PROVINCE")
    private String stateOrProvince;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "COMPANY_WEBSITE")
    private String companyWebsite;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "FAX_NUMBER")
    private String faxNumber;
    @Column(name = "SHIP_ADDRESS")
    private String shipAddress;
    @Column(name = "SHIP_CITY")
    private String shipCity;
    @Column(name = "SHIP_STATED_OR_PROVINCE")
    private String shipStateOrProvince;
    @Column(name = "SHIP_ZIP_CODE")
    private String shipZipCode;
    @Column(name = "SHIP_PHONE_NUMBER")
    private String shipPhoneNumber;

    @OneToMany( mappedBy = "customers",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrdersDTO> ordersCustomer;


    public CustomerDTO(){

    }

    public CustomerDTO(String companyName, String firstName, String lastName, String billingAddress, String city, String stateOrProvince, String zipCode, String email, String companyWebsite, String phoneNumber, String faxNumber, String shipAddress, String shipCity, String shipStateOrProvince, String shipZipCode, String shipPhoneNumber,List<OrdersDTO> ordersCustomer) {
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.billingAddress = billingAddress;
        this.city = city;
        this.stateOrProvince = stateOrProvince;
        this.zipCode = zipCode;
        this.email = email;
        this.companyWebsite = companyWebsite;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipStateOrProvince = shipStateOrProvince;
        this.shipZipCode = shipZipCode;
        this.shipPhoneNumber = shipPhoneNumber;
        this.ordersCustomer = ordersCustomer;

    }

    public List<OrdersDTO> getOrdersCustomer() {
        return ordersCustomer;
    }

    public void setOrdersCustomer(List<OrdersDTO> ordersCustomer) {
        this.ordersCustomer = ordersCustomer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public CustomerDTO setCustomerId(int customerId) {
        this.customerId = customerId;
          return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public CustomerDTO setCompanyName(String companyName) {
        this.companyName = companyName;
          return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipStateOrProvince() {
        return shipStateOrProvince;
    }

    public void setShipStateOrProvince(String shipStateOrProvince) {
        this.shipStateOrProvince = shipStateOrProvince;
    }

    public String getShipZipCode() {
        return shipZipCode;
    }

    public void setShipZipCode(String shipZipCode) {
        this.shipZipCode = shipZipCode;
    }

    public String getShipPhoneNumber() {
        return shipPhoneNumber;
    }

    public void setShipPhoneNumber(String shipPhoneNumber) {
        this.shipPhoneNumber = shipPhoneNumber;
    }


}
