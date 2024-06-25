package com.bosch.realstatemanager.exceptions;

public class UnauthorizedException extends ResponseException {
    public UnauthorizedException() {
        super("You do not own authorization to do the requested action", 401);
    }
}
