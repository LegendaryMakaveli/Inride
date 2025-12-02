package com.indrive.controllers;

import com.indrive.dtos.requets.DriverLoginRequest;
import com.indrive.dtos.requets.PassengerLoginRequest;
import com.indrive.dtos.responses.ApiResponse;
import com.indrive.exceptions.InDriveException;
import com.indrive.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginControllers {
    @Autowired
    private LoginServices loginServices;

    @PostMapping("/driver/login")
    public ResponseEntity<?> driverLogin(@RequestBody DriverLoginRequest request){
        try{
            return new ResponseEntity<>(new ApiResponse(true, loginServices.driverLogin(request)), HttpStatus.OK);
        }
        catch(InDriveException error){
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/passenger/login")
    public ResponseEntity<?> passengerLogin(@RequestBody PassengerLoginRequest request){
        try{
            return new ResponseEntity<>(new ApiResponse(true, loginServices.passengerLogin(request)), HttpStatus.OK);
        }
        catch(InDriveException error){
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
