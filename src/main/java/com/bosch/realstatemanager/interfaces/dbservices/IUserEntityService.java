package com.bosch.realstatemanager.interfaces.dbservices;

import com.bosch.realstatemanager.entities.UserEntity;

import java.util.List;

public interface IUserEntityService {
    void save(UserEntity userEntity);
    List<UserEntity> getUsers();
    UserEntity getUser(Long id);
    UserEntity updateUser(Long id);
}
