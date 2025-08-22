package com.example.transactionmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;


@Entity
@Table(name="ADD_INFO")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
  
    // one to one mapping means,
    // one employee stays at one address only
    @OneToOne
    private Employee employee;
    
    @Version 
    private Long version;

    // Default constructor
    public Address() {}

    // Getters and setters
    public long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public Employee getEmployee() {return employee;}
    public void setEmployee(Employee employee) {this.employee = employee;}

}