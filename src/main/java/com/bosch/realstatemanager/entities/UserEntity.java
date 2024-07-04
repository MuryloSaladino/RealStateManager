package com.bosch.realstatemanager.entities;

import com.bosch.realstatemanager.dto.user.UserCreationPayload;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Set;

@Getter @Entity @Table(name = "UserEntity")
public class UserEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "admin")
    private Boolean admin;

    @Column(name = "deletedAt") @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "userEntity")
    private Set<ScheduleEntity> scheduleEntities;


    public UserEntity() {}

    public UserEntity(String name, String username, String email, String password, String phone, Boolean admin) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.admin = admin != null ? admin : false;
    }


    public void setName(String name) {
        this.updateUpdatedAt();
        this.name = name;
    }

    public void setUsername(String username) {
        this.updateUpdatedAt();
        this.username = username;
    }

    public void setEmail(String email) {
        this.updateUpdatedAt();
        this.email = email;
    }

    public void setPassword(String password) {
        this.updateUpdatedAt();
        this.password = password;
    }

    public void setPhone(String phone) {
        this.updateUpdatedAt();
        this.phone = phone;
    }

    public void setAdmin(Boolean admin) {
        this.updateUpdatedAt();
        this.admin = admin;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.updateUpdatedAt();
        this.deletedAt = deletedAt;
    }
}
