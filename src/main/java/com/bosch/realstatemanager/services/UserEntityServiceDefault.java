package com.bosch.realstatemanager.services;

import com.bosch.realstatemanager.dto.user.UserCreationPayload;
import com.bosch.realstatemanager.dto.user.UserUpdatePayload;
import com.bosch.realstatemanager.entities.UserEntity;
import com.bosch.realstatemanager.exceptions.NotFoundException;
import com.bosch.realstatemanager.interfaces.UserEntityService;
import com.bosch.realstatemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserEntityServiceDefault implements UserEntityService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserEntity save(UserCreationPayload payload) {

        UserEntity newUser = new UserEntity(payload);
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

        return userRepository.save(newUser);
    }

    @Override
    public List<UserEntity> readAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity readById(Long id) {

        var userQuery = userRepository.findById(id);
        if(userQuery.isEmpty()) throw new NotFoundException();

        return userQuery.get();
    }

    @Override
    public UserEntity readByUsername(String username) {

        var userQuery = userRepository.findByUsername(username);
        if(userQuery.isEmpty()) throw new NotFoundException();

        return userQuery.get();
    }

    @Override
    public UserEntity updateUser(Long id, UserUpdatePayload payload) {

        throw new ResponseStatusException(HttpStatusCode.valueOf(501));
    }

    @Override
    public void deleteUser(Long id) {

        var userQuery = userRepository.findById(id);
        if(userQuery.isEmpty()) throw new NotFoundException();

        userRepository.deleteById(id);
    }
}
