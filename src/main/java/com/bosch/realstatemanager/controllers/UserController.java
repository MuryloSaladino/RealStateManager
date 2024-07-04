package com.bosch.realstatemanager.controllers;

import com.bosch.realstatemanager.dto.user.UserCreationPayload;
import com.bosch.realstatemanager.dto.user.UserEntityResponse;
import com.bosch.realstatemanager.dto.user.UserUpdatePayload;
import com.bosch.realstatemanager.entities.UserEntity;
import com.bosch.realstatemanager.exceptions.ForbiddenException;
import com.bosch.realstatemanager.interfaces.UserEntityService;
import com.bosch.realstatemanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserEntityService userService;

    @Autowired
    private UserSession userSession;

    @PostMapping("")
    public ResponseEntity<UserEntityResponse> createUser(@Valid @RequestBody UserCreationPayload user) {

        if(user.getAdmin() && !userSession.getAdmin()) throw new ForbiddenException();

        return ResponseEntity.ok(new UserEntityResponse(userService.create(user)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.readById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<UserEntityResponse>> getAllUsers() {

        List<UserEntityResponse> users = userService
                .readAll()
                .stream()
                .map(UserEntityResponse::new)
                .toList();

        return ResponseEntity.ok(users);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserEntityResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdatePayload user) {

        if(user.getAdmin() && !userSession.getAdmin()) throw new ForbiddenException();

        return ResponseEntity.ok(new UserEntityResponse(userService.updateUser(id, user)));
    }
}
