package com.indrive.controllers;

import com.indrive.dtos.requets.AcceptDriverRequest;
import com.indrive.dtos.requets.BookRideRequest;
import com.indrive.dtos.responses.ApiResponse;
import com.indrive.dtos.responses.BookRideResponse;
import com.indrive.exceptions.InDriveException;
import com.indrive.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @PostMapping("/ride")
    public ResponseEntity<?> bookRide( @RequestBody BookRideRequest request){
        try {
            return new ResponseEntity<>(new ApiResponse(true, passengerService.bookRide(request)), HttpStatus.CREATED);
        }catch (InDriveException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<?> cancelRide(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(new ApiResponse(true, passengerService.cancelRide(id)), HttpStatus.OK);
        }catch (InDriveException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> viewAppliedDrivers(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(new ApiResponse(true, passengerService.viewAppliedDrivers(id)), HttpStatus.OK);
        }catch (InDriveException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/driver")
    public ResponseEntity<?> acceptDriverRequest(@RequestBody AcceptDriverRequest request) {
        try {
            return new ResponseEntity<>(new ApiResponse(true,passengerService.acceptDriverRequest(request)), HttpStatus.OK);
        }catch (InDriveException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


}
