package com.indrive.services;

import com.indrive.ValidationClass.Validations;
import com.indrive.datas.models.Driver;
import com.indrive.datas.models.Passenger;
import com.indrive.datas.repositories.DriverRepository;
import com.indrive.datas.repositories.PassengerRepository;
import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.requets.RegisterDriverRequest;
import com.indrive.dtos.responses.AdminResponses.RegisterPassengerResponse;
import com.indrive.dtos.responses.RegisterDriverResponse;
import com.indrive.exceptions.DriverNotFoundException;
import com.indrive.exceptions.PassengerDoesNotExistExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.indrive.utils.Mapper.mapDriverRequest;
import static com.indrive.utils.Mapper.mapDriverResponse;
import static com.indrive.utils.PassengerMapper.mapToRegisterPassengerRequests;
import static com.indrive.utils.PassengerMapper.mapToRegisterPassengerResponse;

@Service
public class RegisterServiceImpl implements  RegisterService {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private PassengerRepository passengerRepository;


    private final Validations  validations;

    public RegisterServiceImpl(Validations validations) {
        this.validations = validations;
    }

    @Override
    public RegisterDriverResponse registerDriver(RegisterDriverRequest request) {

        validations.driverRequestValidations(request);
        validations.driverPasswordValidation(request);
        driverRepository.findDriverByPlateNumber(request.getPlateNumber()).ifPresent(driver -> {
            throw new DriverNotFoundException("Driver with plate number " + request.getPlateNumber() + " not found.");
        });

        Driver driver = mapDriverRequest(request);
        Driver savedDriver = driverRepository.save(driver);
        return mapDriverResponse(savedDriver);
    }


    @Override
    public RegisterPassengerResponse registerPassenger(RegisterPassengerRequest registerPassengerRequest) {

        validations.passengerRequestValidations(registerPassengerRequest);
        validations.passengerPasswordValidation(registerPassengerRequest);
        passengerRepository.findByEmail(registerPassengerRequest.getEmail()).ifPresent(passenger -> {
            throw new PassengerDoesNotExistExceptions("Passenger with email " + registerPassengerRequest.getEmail() + " already exists.");
        });
        Passenger passenger = mapToRegisterPassengerRequests(registerPassengerRequest);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return mapToRegisterPassengerResponse(savedPassenger);
    }
}
