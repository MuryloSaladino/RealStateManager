package com.bosch.realstatemanager.controllers;

import com.bosch.realstatemanager.entities.UserEntity;
import com.bosch.realstatemanager.interfaces.dbservices.IUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserEntityService userService;

    @PostMapping("")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping("")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
}
