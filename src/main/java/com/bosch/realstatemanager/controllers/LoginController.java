package com.bosch.realstatemanager.controllers;

import com.bosch.realstatemanager.dto.login.LoginPayload;
import com.bosch.realstatemanager.interfaces.dbservices.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    ILoginService loginService;

    @PostMapping("")
    public String login(@RequestBody LoginPayload payload) {
        return loginService.login(payload.email(), payload.password());
    }
}
