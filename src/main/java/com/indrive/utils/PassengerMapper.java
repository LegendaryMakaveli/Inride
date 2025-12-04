package com.indrive.utils;


import com.indrive.datas.models.*;
import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.requets.BookRideRequest;
import com.indrive.dtos.requets.DriverRequest.RideApplicationRequest;
import com.indrive.dtos.requets.DriverRequest.StartRideRequest;
import com.indrive.dtos.responses.AdminResponses.RegisterPassengerResponse;
import com.indrive.dtos.responses.BookRideResponse;
import com.indrive.dtos.responses.DriverRespone.ViewRideResponse;

import java.time.LocalDateTime;
import java.util.HashMap;

public class PassengerMapper {

    public static Passenger mapToRegisterPassengerRequests(RegisterPassengerRequest request) {
        Passenger passenger = new Passenger();
        passenger.setName(request.getName());
        passenger.setEmail(request.getEmail());
        passenger.setPhone(request.getPhone());
        passenger.setAddress(request.getAddress());
        passenger.setPassword(request.getPassword());
        return passenger;
    }

    public static RegisterPassengerResponse mapToRegisterPassengerResponse(Passenger savedPassenger) {
        RegisterPassengerResponse registerPassengerResponse = new RegisterPassengerResponse();
        registerPassengerResponse.setId(savedPassenger.getId());
        registerPassengerResponse.setName(savedPassenger.getName());
        registerPassengerResponse.setEmail(savedPassenger.getEmail());
        registerPassengerResponse.setPhone(savedPassenger.getPhone());
        registerPassengerResponse.setMessage("Register successful");
        return registerPassengerResponse;
    }
    public static RideRequest map(BookRideRequest request){
        RideRequest rideRequest = new RideRequest();
        rideRequest.setPassengerId(request.getPassengerId());
        rideRequest.setStatus(RideStatus.PENDING);
        rideRequest.setDestination(request.getDestination());
        rideRequest.setPrice(request.getFee());
        rideRequest.setAppliedDrivers(new HashMap<String, RideApplication>());
        return rideRequest;
    }
    public static RideApplication map(RideApplicationRequest request){
        RideApplication rideApplication = new RideApplication();
        rideApplication.setDriverId(request.getDriverId());
        rideApplication.setRideRequestId(request.getRideRequestId());
        rideApplication.setDriverPrice(request.getDriverPrice());
        return rideApplication;
    }
    public static ViewRideResponse map(RideRequest rideRequest){
        ViewRideResponse viewRideResponse = new ViewRideResponse();
        viewRideResponse.setPassengerId(rideRequest.getPassengerId());
        viewRideResponse.setPassengerName(rideRequest.getPassengerName());
        viewRideResponse.setDestination(rideRequest.getDestination());
        viewRideResponse.setStatus(rideRequest.getStatus());
        viewRideResponse.setPrice(rideRequest.getPrice());
        viewRideResponse.setId(rideRequest.getId());
        return viewRideResponse;
    }
    public static BookRideResponse mapRideResponse(RideRequest request){
        BookRideResponse bookRideResponse = new BookRideResponse();
        bookRideResponse.setDestination(request.getDestination());
        bookRideResponse.setPrice(request.getPrice());
        bookRideResponse.setRideRequestId(request.getId());
        return bookRideResponse;
    }

    public static Ride mapRide(RideRequest rideRequest){
        Ride ride = new Ride();
        ride.setPassengerId(rideRequest.getPassengerId());
        ride.setDestination(rideRequest.getDestination());
        ride.setRideStatus(rideRequest.getStatus());
        ride.setTimeStamp(LocalDateTime.now());
        return ride;
    }
}
