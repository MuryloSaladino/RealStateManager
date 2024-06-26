package com.bosch.realstatemanager.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "ScheduleEntity")
public class ScheduleEntity extends BaseEntity {

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "hour")
    @Temporal(TemporalType.TIME)
    private Time hour;

    @ManyToOne
    @JoinColumn(name = "userEntityId", nullable = false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "realStateEntityId", nullable = false)
    private RealStateEntity realStateEntity;

    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;


    public ScheduleEntity() {}


    public Date getDate() { return date; }
    public void setDate(Date date) {
        this.updateUpdatedAt();
        this.date = date;
    }

    public Time getHour() { return hour; }
    public void setHour(Time hour) {
        this.updateUpdatedAt();
        this.hour = hour;
    }

    public Timestamp getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Timestamp deletedAt) {
        this.updateUpdatedAt();
        this.deletedAt = deletedAt;
    }

    public UserEntity getUserEntity() { return userEntity; }

    public RealStateEntity getRealStateEntity() { return realStateEntity; }
}
