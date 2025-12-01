package com.indrive.utils;


import com.indrive.datas.models.Driver;
import com.indrive.datas.models.Passenger;
import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.responses.AdminResponses.RegisterPassengerResponse;

import java.util.HashMap;

public class PassengerMapper {

    public static Passenger mapToRegisterPassengerRequests(RegisterPassengerRequest request) {
        Passenger passenger = new Passenger();
        passenger.setName(request.getName());
        passenger.setEmail(request.getEmail());
        passenger.setPhone(request.getPhone());
        passenger.setAddress(request.getAddress());
        return passenger;
    }

    public static RegisterPassengerResponse mapToRegisterPassengerResponse(Passenger passenger) {
        RegisterPassengerResponse registerPassengerResponse = new RegisterPassengerResponse();
        registerPassengerResponse.setName(passenger.getName());
        registerPassengerResponse.setEmail(passenger.getEmail());
        registerPassengerResponse.setPhone(passenger.getPhone());
        registerPassengerResponse.setMessage("Register successful");
        return registerPassengerResponse;
    }
    public static RideRequest map(BookRideRequest request){
        RideRequest rideRequest = new RideRequest();
        rideRequest.setPassengerId(request.getPassengerId());
        rideRequest.setStatus(RideStatus.PENDING);
        rideRequest.setDestination(request.getDestination());
        rideRequest.setPrice(request.getFee());
        rideRequest.setAppliedDrivers(new HashMap<String, Driver>());
        return rideRequest;
    }
}
