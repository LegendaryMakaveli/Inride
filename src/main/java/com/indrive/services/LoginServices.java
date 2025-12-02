package com.indrive.services;


import com.indrive.dtos.requets.DriverLoginRequest;
import com.indrive.dtos.requets.PassengerLoginRequest;
import com.indrive.dtos.responses.DriverLoginResponse;
import com.indrive.dtos.responses.PassengerLoginResponse;

public interface LoginServices {
    DriverLoginResponse driverLogin(DriverLoginRequest request);
    PassengerLoginResponse passengerLogin(PassengerLoginRequest request);
}
