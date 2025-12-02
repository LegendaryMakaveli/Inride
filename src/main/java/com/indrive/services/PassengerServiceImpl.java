package com.indrive.services;

import com.indrive.datas.models.Passenger;
import com.indrive.datas.repositories.PassengerRepository;
import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.responses.AdminResponses.RegisterPassengerResponse;
import com.indrive.utils.PassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository repository;

    @Override
    public RegisterPassengerResponse registerPassenger(RegisterPassengerRequest request) {
        Passenger passenger = PassengerMapper.mapToRegisterPassengerRequests(request);
        repository.save(passenger);
        return PassengerMapper.mapToRegisterPassengerResponse(passenger);
    }
}
