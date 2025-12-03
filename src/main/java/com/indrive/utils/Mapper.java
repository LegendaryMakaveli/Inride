package com.indrive.utils;

import com.indrive.datas.models.Admin;
import com.indrive.datas.models.Driver;
import com.indrive.datas.models.Passenger;
import com.indrive.datas.models.RideRequest;
import com.indrive.dtos.requets.AdminRequests.DeleteDriverRequest;
import com.indrive.dtos.requets.AdminRequests.DeletePassengerRequest;
import com.indrive.dtos.requets.AdminRequests.RegisterAdminRequest;
import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.requets.DriverLoginRequest;
import com.indrive.dtos.requets.FindDriverByIdRequest;
import com.indrive.dtos.requets.PassengerLoginRequest;
import com.indrive.dtos.responses.AdminResponses.*;
import com.indrive.dtos.responses.CancelRideResponse;
import com.indrive.dtos.responses.DriverLoginResponse;
import com.indrive.dtos.responses.PassengerLoginResponse;
import com.indrive.dtos.requets.RegisterDriverRequest;
import com.indrive.dtos.responses.AdminResponses.DeleteDriverResponse;
import com.indrive.dtos.responses.AdminResponses.DeletePassengerResponse;
import com.indrive.dtos.responses.AdminResponses.FindDriverByIdResponse;
import com.indrive.dtos.responses.AdminResponses.RegisterAdminResponse;
import com.indrive.dtos.responses.RegisterDriverResponse;

public class Mapper {
    public static Admin mapRequestAdmin(RegisterAdminRequest registerAdminRequest) {
        Admin admin = new Admin();
        admin.setName(registerAdminRequest.getName().trim().toLowerCase());
        admin.setPassword(registerAdminRequest.getPassword().trim().toLowerCase());
        admin.setEmail(registerAdminRequest.getEmail().trim().toLowerCase());
        admin.setPhoneNumber(registerAdminRequest.getPhoneNumber().trim());
        admin.setAddress(registerAdminRequest.getAddress().trim().toLowerCase());
        admin.setUsername(registerAdminRequest.getUsername().trim().toLowerCase());
        return admin;
    }

    public static Driver mapDriverRequest(RegisterDriverRequest request) {
        Driver driver = new Driver();
        driver.setName(request.getName());
        driver.setEmail(request.getEmail());
        driver.setPassword(request.getPassword());
        driver.setPlateNumber(request.getPlateNumber());
        driver.setAddress(request.getAddress());
        driver.setPhone(request.getPhone());
        return driver;
    }

    public  static RegisterDriverResponse mapDriverResponse(Driver savedDriver) {
        RegisterDriverResponse registerDriverResponse = new RegisterDriverResponse();
        registerDriverResponse.setUsername(savedDriver.getName());
        registerDriverResponse.setMessage("Registered successfully");
        return registerDriverResponse;
    }

    public static RegisterAdminResponse mapResponseAdmin(Admin savedAdmin) {
        RegisterAdminResponse registerAdminResponse = new RegisterAdminResponse();
        registerAdminResponse.setUsername(savedAdmin.getUsername().trim().toLowerCase());
        registerAdminResponse.setMessage(savedAdmin.getName() + "registered successfully");
        return  registerAdminResponse;
    }

    public static Driver mapToDeleteDriverRequest(DeleteDriverRequest request) {
        Driver myDriver = new Driver();
        myDriver.setId(request.getId());

        return myDriver;
    }

    public static DeleteDriverResponse mapToDeleteDriverResponse(Driver driver) {
        DeleteDriverResponse response = new DeleteDriverResponse();
        response.setMessage("Driver with ID " + driver.getId() + " " + "Name: " + driver.getName() + " " + "Plate Number: " + driver.getPlateNumber() + " has been deleted successfully.");

        return response;
    }

    public static Passenger mapToPassengerRequest(DeletePassengerRequest request) {
        Passenger myPassenger = new Passenger();
        myPassenger.setId(request.getId());

        return myPassenger;
    }

    public static DeletePassengerResponse mapToPassengerResponse(Passenger passenger) {
        DeletePassengerResponse response = new DeletePassengerResponse();
        response.setMessage("Passenger with ID " + passenger.getId() + " " + "Name: " + passenger.getName() + " " + "Phone Number: " + passenger.getPhone() + " has been deleted successfully.");

        return response;
    }

    public static Driver mapToFindDriverRequest(FindDriverByIdRequest request){
        Driver newDriver = new Driver();
        newDriver.setId(request.getId());

        return newDriver;
    }

    public static FindDriverByIdResponse mapToFindDriverResponse(Driver driver){
        FindDriverByIdResponse response = new FindDriverByIdResponse();
        response.setDriverId(driver.getId());
        response.setDriverEmail(driver.getEmail().trim().toLowerCase());
        response.setDriverName(driver.getName().trim().toLowerCase());
        response.setDriverPhoneNumber(driver.getPhone().trim());
        response.setDriverPlateNumber(driver.getPlateNumber().trim().toLowerCase());

        return response;
    }

    public static Driver mapToLoginDriverRequest(DriverLoginRequest request){
        Driver newDriver = new Driver();
        newDriver.setEmail(request.getDriverEmail().trim().toLowerCase());
        newDriver.setPassword(request.getDriverPassword().trim().toLowerCase());

        return newDriver;
    }

    public static DriverLoginResponse mapToLoginDriverResponse(){
        DriverLoginResponse response = new DriverLoginResponse();
        response.setMessage("Login successful");

        return response;
    }

    public static Passenger mapToLoginPassengerRequest(PassengerLoginRequest request){
        Passenger newPassenger = new Passenger();
        newPassenger.setEmail(request.getPassengerEmail().trim().toLowerCase());
        newPassenger.setPassword(request.getPassengerPassword().trim().toLowerCase());

        return newPassenger;
    }

    public static PassengerLoginResponse mapToRegisterPassengerResponse(){
        PassengerLoginResponse response = new PassengerLoginResponse();
        response.setMessage("Login successful");

        return response;
    }
    public static CancelRideResponse mapToCancelRideResponse(RideRequest rideRequest){
        CancelRideResponse response = new CancelRideResponse();
        response.setRideRequestId(rideRequest.getId());
        return response;
    }
}

