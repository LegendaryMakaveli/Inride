package com.indrive.controllers;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.indrive.dtos.requets.DriverRequest.EndRideRequest;
import com.indrive.dtos.requets.DriverRequest.RideApplicationRequest;
import com.indrive.dtos.requets.DriverRequest.StartRideRequest;
import com.indrive.dtos.requets.DriverRequest.ViewRideRequest;
import com.indrive.dtos.responses.ApiResponse;
import com.indrive.dtos.responses.DriverRespone.RideApplicationResponse;
import com.indrive.dtos.responses.DriverRespone.ViewRideResponse;
import com.indrive.exceptions.InDriveException;
import com.indrive.services.DriverService;
import com.indrive.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/apply")
    public ResponseEntity<?> applyForRideRequest(@RequestBody RideApplicationRequest request){
        try {
            return new ResponseEntity<>(new ApiResponse(true, driverService.applyForRideRequest(request)), HttpStatus.OK);
        }catch (InDriveException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/view")
    public ResponseEntity<?> viewAvailableRides( @RequestBody ViewRideRequest request){
        try {
            return new ResponseEntity<>(new ApiResponse(true, driverService.viewAvailableRides(request)), HttpStatus.OK);
        }catch (InDriveException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/start")
    public ResponseEntity<?> startRideRequest(@RequestBody StartRideRequest request){
        try{
            return new ResponseEntity<>(new ApiResponse(true,driverService.startRide(request)),HttpStatus.OK);
        }catch (InDriveException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/end")
    public ResponseEntity<?> endRideRequest(@RequestBody EndRideRequest request){
        try {
            return new ResponseEntity<>(new ApiResponse(true,driverService.endRide(request)),HttpStatus.OK);
        }catch (InDriveException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
