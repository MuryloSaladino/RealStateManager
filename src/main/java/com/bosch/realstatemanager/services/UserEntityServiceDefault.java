package com.bosch.realstatemanager.services;

import com.bosch.realstatemanager.dto.user.UserCreationPayload;
import com.bosch.realstatemanager.dto.user.UserEntityResponse;
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
    public UserEntity create(UserCreationPayload payload) {

        UserEntity newUser = payload.toUser();
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

        var query = userRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        UserEntity user = query.get();
        user.setUsername(payload.getUsername() != null ? payload.getUsername() : user.getUsername());
        user.setEmail(payload.getEmail() != null ? payload.getEmail() : user.getEmail());
        user.setName(payload.getName() != null ? payload.getName() : user.getName());
        user.setPhone(payload.getPhone() != null ? payload.getPhone() : user.getPhone());
        user.setAdmin(payload.getAdmin() != null ? payload.getAdmin() : user.getAdmin());
        user.setPassword(
                payload.getPassword() != null ?
                bCryptPasswordEncoder.encode(payload.getPassword()) :
                user.getPassword()
        );

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

        var userQuery = userRepository.findById(id);
        if(userQuery.isEmpty()) throw new NotFoundException();

        userRepository.deleteById(id);
    }
}
