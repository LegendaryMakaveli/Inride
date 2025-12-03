package com.indrive.controllers;

import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.requets.RegisterDriverRequest;
import com.indrive.dtos.responses.ApiResponse;
import com.indrive.exceptions.InDriveException;
import com.indrive.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterServiceController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/RegisterPassenger")
    public ResponseEntity<?> registerPassengerResponse(@RequestBody RegisterPassengerRequest registerPassengerRequest) {
        try {
            return new ResponseEntity<>(new ApiResponse(true, registerService.registerPassenger(registerPassengerRequest)), HttpStatus.CREATED);
        }
        catch (InDriveException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/RegisterDriver")
    public ResponseEntity<?> registerDriverResponse(@RequestBody RegisterDriverRequest registerDriverRequest) {
        try {
            return new ResponseEntity<>(new ApiResponse(true, registerService.registerDriver(registerDriverRequest)), HttpStatus.CREATED);

        }
        catch (InDriveException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
