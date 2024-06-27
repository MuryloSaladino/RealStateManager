package com.bosch.realstatemanager.controllers;

import com.bosch.realstatemanager.dto.user.UserCreationPayload;
import com.bosch.realstatemanager.dto.user.UserEntityResponse;
import com.bosch.realstatemanager.entities.UserEntity;
import com.bosch.realstatemanager.interfaces.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserEntityService userService;

    @PostMapping("")
    public ResponseEntity<UserEntityResponse> createUser(@RequestBody UserCreationPayload user) {
        return ResponseEntity.ok(new UserEntityResponse(userService.save(user)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.readById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.readAll());
    }
}
