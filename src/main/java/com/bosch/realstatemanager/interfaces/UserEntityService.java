package com.bosch.realstatemanager.interfaces;

import com.bosch.realstatemanager.dto.user.UserCreationPayload;
import com.bosch.realstatemanager.dto.user.UserUpdatePayload;
import com.bosch.realstatemanager.entities.UserEntity;

import java.util.List;

public interface UserEntityService {
    UserEntity create(UserCreationPayload payload);
    List<UserEntity> readAll();
    UserEntity readById(Long id);
    UserEntity readByUsername(String username);
    UserEntity updateUser(Long id, UserUpdatePayload payload);
    void deleteUser(Long id);
}
