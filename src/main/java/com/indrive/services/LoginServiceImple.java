package com.indrive.services;

import com.indrive.datas.models.Driver;
import com.indrive.datas.models.Passenger;
import com.indrive.datas.repositories.DriverRepository;
import com.indrive.datas.repositories.PassengerRepository;
import com.indrive.dtos.requets.DriverLoginRequest;
import com.indrive.dtos.requets.PassengerLoginRequest;
import com.indrive.dtos.responses.DriverLoginResponse;
import com.indrive.dtos.responses.PassengerLoginResponse;
import com.indrive.exceptions.DriverNotFoundException;
import com.indrive.exceptions.InvalidCredentialsException;
import com.indrive.exceptions.PassengerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.indrive.utils.Mapper.*;

@AllArgsConstructor
@Service
public class LoginServiceImple implements LoginServices{

    @Autowired
    private final DriverRepository driverRepository;
    @Autowired
    private final PassengerRepository passengerRepository;

    @Override
    public DriverLoginResponse driverLogin(DriverLoginRequest request) {
        if(request.getDriverEmail() == null || request.getDriverEmail().trim().isEmpty()) throw new InvalidCredentialsException("Email and password are required");
        if(request.getDriverPassword() == null || request.getDriverPassword().trim().isEmpty())throw new InvalidCredentialsException("Password cannot be empty");

        Driver driver = driverRepository.findByEmail(request.getDriverEmail()).orElseThrow(() -> new DriverNotFoundException("Driver not found"));

        if(!request.getDriverPassword().equals(driver.getPassword())) throw new InvalidCredentialsException("Incorrect password");

        driver.setActiveStatus(true);
        driverRepository.save(driver);
        return mapToLoginDriverResponse();
    }


    @Override
    public PassengerLoginResponse passengerLogin(PassengerLoginRequest request) {
        if(request.getPassengerEmail() == null || request.getPassengerPassword() == null) throw new InvalidCredentialsException("Email and password are required");

        Passenger passenger = passengerRepository.findByEmail(request.getPassengerEmail()).orElseThrow(() -> new PassengerNotFoundException("Passenger not found"));

        if(!request.getPassengerPassword().equals(passenger.getPassword())) throw new InvalidCredentialsException("Incorrect password");

        passenger.setActiveStatus(true);
        passengerRepository.save(passenger);
        return mapToRegisterPassengerResponse();
    }
}
