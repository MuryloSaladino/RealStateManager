package com.bosch.realstatemanager.interfaces;

import com.bosch.realstatemanager.entities.UserEntity;

import java.util.List;

public interface UserEntityService {
    UserEntity save(UserEntity userEntity);
    List<UserEntity> getUsers();
    UserEntity getUser(Long id);
    UserEntity updateUser(Long id);
    void deleteUser(Long id);
}
