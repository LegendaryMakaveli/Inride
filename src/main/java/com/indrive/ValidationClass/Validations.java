package com.indrive.ValidationClass;

import com.indrive.dtos.requets.AdminRequests.RegisterAdminRequest;
import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.requets.RegisterDriverRequest;
import com.indrive.exceptions.AdminExceptions.AdminNotFoundException;
import com.indrive.exceptions.AdminExceptions.AdminValidationException;
import com.indrive.exceptions.DriverNotFoundException;
import com.indrive.exceptions.PassengerNotFoundException;
import com.indrive.exceptions.PasswordMustBeStrongException;
import org.springframework.stereotype.Service;

@Service
public class Validations {

    public void adminPasswordValidation(RegisterAdminRequest registerAdminRequest) {
        if(registerAdminRequest.getPassword().length() < 6) throw new AdminValidationException("Password must be at least 6 characters long.");
        if(registerAdminRequest.getPassword().trim().isEmpty()) throw new AdminValidationException("Password cannot be empty.");
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

    public void driverPasswordValidation(RegisterDriverRequest registerDriverRequest) {
        if(registerDriverRequest.getPassword().length()<6) throw new PasswordMustBeStrongException("Password must be at least 6 characters long.");
        if(registerDriverRequest.getPassword().trim().isEmpty()) throw new PasswordMustBeStrongException("Password cannot be empty.");

    }

    public void driverRequestValidations(RegisterDriverRequest registerDriverRequest) {
        if(registerDriverRequest.getEmail() == null || registerDriverRequest.getEmail().trim().isEmpty()) throw new DriverNotFoundException("Email cannot be empty.");
        if(registerDriverRequest.getName() == null || registerDriverRequest.getName().trim().isEmpty()) throw new DriverNotFoundException("Name cannot be empty.");
        if(registerDriverRequest.getPlateNumber() == null || registerDriverRequest.getPlateNumber().trim().isEmpty()) throw new DriverNotFoundException("Plate number cannot be empty.");
        if(registerDriverRequest.getAddress() == null || registerDriverRequest.getAddress().trim().isEmpty()) throw new DriverNotFoundException("Address cannot be empty.");
        if(registerDriverRequest.getPhone()== null || registerDriverRequest.getPhone().trim().isEmpty()) throw new DriverNotFoundException("Phone number cannot be empty.");
        if(registerDriverRequest.getPhone().length() != 11) throw new DriverNotFoundException("Phone number must be 11 digits long.");


    }

    public  void  passengerPasswordValidation(RegisterPassengerRequest registerPassengerRequest) {
        if (registerPassengerRequest.getPassword().length()<6) throw new PasswordMustBeStrongException("password must be at least 6 characters long.");
        if(registerPassengerRequest.getPassword().trim().isEmpty()) throw new PasswordMustBeStrongException("Password cannot be empty.");
    }
    public void passengerRequestValidations(RegisterPassengerRequest registerPassengerRequest) {
        if(registerPassengerRequest.getPhone() == null || registerPassengerRequest.getPhone().trim().isEmpty()) throw new PassengerNotFoundException("Phone cannot be empty.");
        if(registerPassengerRequest.getName() == null || registerPassengerRequest.getName().trim().isEmpty()) throw new PassengerNotFoundException("Name cannot be empty.");
        if(registerPassengerRequest.getEmail() == null || registerPassengerRequest.getEmail().trim().isEmpty()) throw new PassengerNotFoundException("Email cannot be empty.");
        if(registerPassengerRequest.getAddress() == null || registerPassengerRequest.getAddress().trim().isEmpty()) throw new PassengerNotFoundException("Address cannot be empty.");
        if(registerPassengerRequest.getPhone().length() != 11) throw new PassengerNotFoundException("Phone number must be 11 digits long.");
    }
}
