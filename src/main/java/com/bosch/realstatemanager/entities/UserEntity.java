package com.bosch.realstatemanager.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "UserEntity")
public class UserEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private boolean admin;

    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "userEntity")
    private Set<ScheduleEntity> scheduleEntities;


    public String getName() { return name; }
    public void setName(String name) {
        this.updateUpdatedAt();
        this.name = name;
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
