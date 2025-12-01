package com.ValidationClass;

import com.indrive.dtos.requets.AdminRequests.RegisterAdminRequest;
import com.indrive.exceptions.AdminExceptions.AdminNotFoundException;
import com.indrive.exceptions.AdminExceptions.AdminValidationException;

public class Validations {

    public void adminPasswordValidation(RegisterAdminRequest registerAdminRequest) {
        if(registerAdminRequest.getPassword().length() < 6) throw new AdminValidationException("Password must be at least 6 characters long.");
        if(registerAdminRequest.getPassword() == null || registerAdminRequest.getPassword().trim().isEmpty()) throw new AdminValidationException("Password cannot be empty.");
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])[^\\s]{6,15}$";
        if(!registerAdminRequest.getPassword().matches(passwordPattern))throw new AdminValidationException("Passwords do not match");
    }
    public void adminRequestValidations(RegisterAdminRequest registerAdminRequest) {
        if(registerAdminRequest.getEmail() == null || registerAdminRequest.getEmail().trim().isEmpty()) throw new AdminNotFoundException("Email cannot be empty.");
        if(registerAdminRequest.getUsername() == null || registerAdminRequest.getUsername().trim().isEmpty()) throw new AdminNotFoundException("Username cannot be empty.");
        if(registerAdminRequest.getName() == null || registerAdminRequest.getName().trim().isEmpty()) throw new AdminNotFoundException("Name cannot be empty.");
        if(registerAdminRequest.getPhoneNumber() == null || registerAdminRequest.getPhoneNumber().trim().isEmpty()) throw new AdminNotFoundException("Phone number cannot be empty.");
        if(registerAdminRequest.getAddress() == null || registerAdminRequest.getAddress().trim().isEmpty()) throw new AdminNotFoundException("Address cannot be empty.");
        if(registerAdminRequest.getPhoneNumber().length() != 11) throw new AdminNotFoundException("Phone number must be 11 digits long.");
        String phoneNumberPattern = "^(?:\\+234|0)(7[0-9]|8[0-9]|9[0-1])[0-9]{7}$\n";
        if(!registerAdminRequest.getPhoneNumber().matches(phoneNumberPattern))throw new AdminNotFoundException("Phone number must be 11 digits long.");
    }
}
