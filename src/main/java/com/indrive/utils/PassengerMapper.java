package com.indrive.utils;


import com.indrive.datas.models.Passenger;
import com.indrive.dtos.requets.RegisterPassengerRequest;
import com.indrive.dtos.responses.RegisterPassengerResponse;

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
}
