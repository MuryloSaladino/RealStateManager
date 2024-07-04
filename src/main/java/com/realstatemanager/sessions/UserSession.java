package com.realstatemanager.sessions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSession {
    private Long id;
    private Boolean admin;

    public UserSession(Long id, Boolean admin) {
        this.id = id;
        this.admin = admin;
    }
}
