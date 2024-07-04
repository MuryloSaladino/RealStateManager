package com.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Entity @Table(name = "AddressEntity")
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

    @Getter @Setter
    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;

    @OneToOne(mappedBy = "address")
    public RealStateEntity realStateEntity;


    public AddressEntity() {}

    public AddressEntity(String street, String zipcode, Integer number, String city, String state) {
        super();
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.city = city;
        this.state = state;
    }


    public void setStreet(String street) {
        this.updateUpdatedAt();
        this.street = street;
    }

    public void setZipcode(String zipcode) {
        this.updateUpdatedAt();
        this.zipcode = zipcode;
    }

    public void setNumber(Integer number) {
        this.updateUpdatedAt();
        this.number = number;
    }

    public void setCity(String city) {
        this.updateUpdatedAt();
        this.city = city;
    }

    public void setState(String state) {
        this.updateUpdatedAt();
        this.state = state;
    }
}
