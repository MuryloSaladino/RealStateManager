package com.bosch.realstatemanager.services.dbservices;

import com.bosch.realstatemanager.entities.UserEntity;
import com.bosch.realstatemanager.interfaces.dbservices.IUserEntityService;
import com.bosch.realstatemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserEntityServiceDefault implements IUserEntityService {

    @Autowired
    private UserRepository userRepository;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);

    @Override
    public void save(UserEntity user) {

        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    @Override
    public List<UserEntity> getUsers() {

        return userRepository.findAll();
    }

    @Override
    public UserEntity getUser(Long id) {

        var user = userRepository.findById(id);

        if(user.isEmpty()) throw new ResponseStatusException(HttpStatusCode.valueOf(404));

        return user.get();
    }

    @Override
    public void deleteUser(Long id) {

        var user = userRepository.findById(id);

        if(user.isEmpty()) throw new ResponseStatusException(HttpStatusCode.valueOf(404));

        userRepository.deleteById(id);
    }

    @Override
    public UserEntity updateUser(Long id) {

        throw new ResponseStatusException(HttpStatusCode.valueOf(501));
    }
}
