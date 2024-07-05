package com.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Getter @Entity @Table(name = "ScheduleEntity")
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

    @Setter
    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;


    public ScheduleEntity() {}

    public ScheduleEntity(Date date, Time hour, UserEntity userEntity, RealStateEntity realStateEntity) {
        super();
        this.date = date;
        this.hour = hour;
        this.userEntity = userEntity;
        this.realStateEntity = realStateEntity;
    }


    public void setDate(Date date) {
        this.updateUpdatedAt();
        this.date = date;
    }

    public void setHour(Time hour) {
        this.updateUpdatedAt();
        this.hour = hour;
    }
}
