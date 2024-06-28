package com.bosch.realstatemanager.sessions;

public class UserSession {

    private Long id;
    private boolean admin;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
