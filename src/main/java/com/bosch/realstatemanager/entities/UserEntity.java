package com.bosch.realstatemanager.entities;

import com.bosch.realstatemanager.dto.user.UserCreationPayload;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "UserEntity")
public class UserEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "admin")
    private boolean admin;

    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "userEntity")
    private Set<ScheduleEntity> scheduleEntities;


    public UserEntity() {}

    public UserEntity(UserCreationPayload payload) {
        super();
        this.name = payload.name();
        this.username = payload.username();
        this.email = payload.email();
        this.password = payload.password();
        this.phone = payload.phone();
        this.admin = payload.admin();
    }


    public String getName() { return name; }
    public void setName(String name) {
        this.updateUpdatedAt();
        this.name = name;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.updateUpdatedAt();
        this.username = username;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.updateUpdatedAt();
        this.email = email;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        this.updateUpdatedAt();
        this.password = password;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        this.updateUpdatedAt();
        this.phone = phone;
    }

    public boolean isAdmin() { return admin; }
    public void setAdmin(boolean admin) {
        this.updateUpdatedAt();
        this.admin = admin;
    }

    public Timestamp getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Timestamp deletedAt) {
        this.updateUpdatedAt();
        this.deletedAt = deletedAt;
    }

    public Set<ScheduleEntity> getScheduleEntities() { return scheduleEntities; }
}
