package com.letsstartcoding.springbootrestapiexample.dto;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


@Entity
@Table(name="trn_employees")
public class EmployeeDTO implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;
    @Column(name = "FIRST_NAME")
    private  String firstName;
    @Column(name = "LAST_NAME")
    private  String lastName;
    @Column(name = "TITLE")
    private  String title;
    @Column(name = "WORK_PHONE")
    private  String workPhone;


    @OneToMany(mappedBy = "employees",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrdersDTO> ordersEmployee;


    public EmployeeDTO(){

    }


    public EmployeeDTO(String firstName, String lastName, String title, String workPhone,List<OrdersDTO> ordersEmployee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.workPhone = workPhone;
        this.ordersEmployee = ordersEmployee;
    }

    public List<OrdersDTO> getOrdersEmployee() {
        return ordersEmployee;
    }

    public void setOrdersEmployee(List<OrdersDTO> ordersEmployee) {
        this.ordersEmployee = ordersEmployee;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public EmployeeDTO setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", workPhone='" + workPhone + '\'' +
                '}';
    }
}
