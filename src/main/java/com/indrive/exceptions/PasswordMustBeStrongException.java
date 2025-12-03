package com.indrive.exceptions;

public class PasswordMustBeStrongException extends InDriveException{
    public PasswordMustBeStrongException(String message) {
        super(message);
    }
}
