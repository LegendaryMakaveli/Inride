package com.indrive.controllers;

import com.indrive.dtos.requets.BookRideRequest;
import com.indrive.dtos.responses.ApiResponse;
import com.indrive.dtos.responses.BookRideResponse;
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
        return new ResponseEntity<>(new ApiResponse(true,passengerService.bookRide(request)), HttpStatus.CREATED);
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<?> cancelRide(@PathVariable("id") String id){
        return new ResponseEntity<>(new ApiResponse(true,passengerService.cancelRide(id)), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> viewAppliedDrivers(@PathVariable("id") String id){
        return  new ResponseEntity<>(new ApiResponse(true,passengerService.viewAppliedDrivers(id)) , HttpStatus.OK);
    }

}
