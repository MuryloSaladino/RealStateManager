package com.bosch.realstatemanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "AddressEntity")
public class AddressEntity extends BaseEntity {

    @Column(name = "street")
    private String street;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "number")
    private Integer number;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;


    public String getStreet() { return street; }
    public void setStreet(String street) {
        this.updateUpdatedAt();
        this.street = street;
    }

    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) {
        this.updateUpdatedAt();
        this.zipcode = zipcode;
    }

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) {
        this.updateUpdatedAt();
        this.number = number;
    }

    public String getCity() { return city; }
    public void setCity(String city) {
        this.updateUpdatedAt();
        this.city = city;
    }

    public String getState() { return state; }
    public void setState(String state) {
        this.updateUpdatedAt();
        this.state = state;
    }
}
