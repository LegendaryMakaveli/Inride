package com.indrive.exceptions.AdminExceptions;

import com.indrive.exceptions.InDriveException;

public class AdminNotFoundException extends InDriveException {
    public AdminNotFoundException(String message) {
        super(message);
    }
}
