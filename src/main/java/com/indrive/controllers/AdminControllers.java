package com.indrive.controllers;


import com.indrive.dtos.requets.AdminRequests.DeleteDriverRequest;
import com.indrive.dtos.requets.AdminRequests.DeletePassengerRequest;
import com.indrive.dtos.requets.AdminRequests.RegisterAdminRequest;
import com.indrive.dtos.requets.FindDriverByIdRequest;
import com.indrive.dtos.responses.ApiResponse;
import com.indrive.exceptions.InDriveException;
import com.indrive.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminControllers {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/registerAdmin")
    public ResponseEntity<?>registerAdmin(@RequestBody RegisterAdminRequest request){
        try{
            return new ResponseEntity<>(new ApiResponse(true, adminService.registerAdmin(request)), HttpStatus.CREATED);
        }
        catch(InDriveException error){
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/admin/deleteDriver")
    public ResponseEntity<?>deleteDriver(@RequestBody DeleteDriverRequest request){
        try{
            return new ResponseEntity<>(new ApiResponse(true, adminService.deleteDriver(request)), HttpStatus.OK);
        }
        catch(InDriveException error){
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/admin/deletePassenger")
    public ResponseEntity<?>deletePassenger(@RequestBody DeletePassengerRequest request){
        try{
            return new ResponseEntity<>(new ApiResponse(true, adminService.deletePassenger(request)), HttpStatus.OK);
        }
        catch(InDriveException error){
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/admin/getAllDrivers")
    public ResponseEntity<?>getAllDrivers(){
        return new ResponseEntity<>(adminService.getAllDrivers(), HttpStatus.OK);
    }

    @GetMapping("/admin/getAllPassengers")
    public ResponseEntity<?>getAllPassengers(){
        return new ResponseEntity<>(adminService.getAllPassengers(), HttpStatus.OK);
    }

    @PostMapping("/admin/findDriverById")
    public ResponseEntity<?>findDriverById(@RequestBody FindDriverByIdRequest request){
        try{
            return new ResponseEntity<>(new ApiResponse(true, adminService.findDriver(request)), HttpStatus.OK);
        }
        catch(InDriveException error){
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
