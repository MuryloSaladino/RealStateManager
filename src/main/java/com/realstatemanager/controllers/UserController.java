package com.realstatemanager.controllers;

import com.realstatemanager.dto.user.UserCreationPayload;
import com.realstatemanager.dto.user.UserEntityResponse;
import com.realstatemanager.dto.user.UserUpdatePayload;
import com.realstatemanager.entities.UserEntity;
import com.realstatemanager.exceptions.ForbiddenException;
import com.realstatemanager.interfaces.UserEntityService;
import com.realstatemanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/users")
public class UserController {

    @Autowired
    private UserEntityService userService;

    @Autowired
    private UserSession userSession;

    @PostMapping("")
    protected ResponseEntity<UserEntityResponse> createUser(@Valid @RequestBody UserCreationPayload user) {

        if(user.getAdmin() && !userSession.getAdmin()) throw new ForbiddenException();

        return ResponseEntity.ok(new UserEntityResponse(userService.create(user)));
    }

    @GetMapping("/{id}")
    protected ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.readById(id));
    }

    @GetMapping("")
    protected ResponseEntity<List<UserEntityResponse>> getAllUsers() {

        List<UserEntityResponse> users = userService
                .readAll()
                .stream()
                .map(UserEntityResponse::new)
                .toList();

        return ResponseEntity.ok(users);
    }

    @PatchMapping("/{id}")
    protected ResponseEntity<UserEntityResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdatePayload user) {

        if((user.getAdmin() != null && user.getAdmin()) && !userSession.getAdmin()) throw new ForbiddenException();
        if(!userSession.getId().equals(id) && !userSession.getAdmin()) throw new ForbiddenException();

        return ResponseEntity.ok(new UserEntityResponse(userService.updateUser(id, user)));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<?> deleteUser(@PathVariable Long id) {

        if(!userSession.getId().equals(id) && !userSession.getAdmin()) throw new ForbiddenException();

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}
