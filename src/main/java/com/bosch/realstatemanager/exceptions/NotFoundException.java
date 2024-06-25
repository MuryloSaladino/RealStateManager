package com.bosch.realstatemanager.exceptions;

public class NotFoundException extends ResponseException {
    public NotFoundException() {
        super("The requested service was not found", 404);
    }
}
