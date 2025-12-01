package com.indrive.services;

import com.indrive.ValidationClass.Validations;
import com.indrive.datas.models.Admin;
import com.indrive.datas.models.Driver;
import com.indrive.datas.models.Passenger;
import com.indrive.datas.repositories.AdminRepository;
import com.indrive.datas.repositories.DriverRepository;
import com.indrive.datas.repositories.PassengerRepository;
import com.indrive.dtos.requets.AdminRequests.DeleteDriverRequest;
import com.indrive.dtos.requets.AdminRequests.DeletePassengerRequest;
import com.indrive.dtos.requets.AdminRequests.RegisterAdminRequest;
import com.indrive.dtos.requets.FindDriverByIdRequest;
import com.indrive.dtos.responses.AdminResponses.DeleteDriverResponse;
import com.indrive.dtos.responses.AdminResponses.DeletePassengerResponse;
import com.indrive.dtos.responses.AdminResponses.FindDriverByIdResponse;
import com.indrive.dtos.responses.AdminResponses.RegisterAdminResponse;
import com.indrive.exceptions.AdminExceptions.AdminNotFoundException;

import com.indrive.exceptions.DriverNotFoundException;
import com.indrive.exceptions.ValidateDriverException;
import com.indrive.exceptions.PassengerNotFoundException;
import com.indrive.exceptions.ValidatePassengerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.indrive.utils.Mapper.*;


@Service
public class AdminServiceImpl implements  AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private Validations validate;



    @Override
    public RegisterAdminResponse registerAdmin(RegisterAdminRequest registerAdminRequest) {
        validate.adminPasswordValidation(registerAdminRequest);
        validate.adminRequestValidations(registerAdminRequest);
        adminRepository.findAdminByEmail(registerAdminRequest.getEmail()).ifPresent(existingAdmin -> {
            throw new AdminNotFoundException("Admin with email " + registerAdminRequest.getEmail() + " already exists.");
        });

        Admin admin = mapRequestAdmin(registerAdminRequest);
        Admin savedAdmin = adminRepository.save(admin);
        return mapResponseAdmin(savedAdmin);
    }

    @Override
    public DeleteDriverResponse deleteDriver(DeleteDriverRequest request) {
        if(request.getId() ==  null || request.getId().trim().isEmpty());
        Driver myDriver = mapToDeleteDriverRequest(request);
        driverRepository.findById(myDriver.getId()).orElseThrow(() -> new AdminNotFoundException("Driver with ID " + myDriver.getId() + " not found."));
        myDriver.setDeleted(true);
        return mapToDeleteDriverResponse(myDriver);
    }

    @Override
    public DeletePassengerResponse deletePassenger(DeletePassengerRequest request) {
        if(request.getId() ==  null || request.getId().trim().isEmpty())throw new ValidatePassengerException("Passenger ID cannot be empty.");
        Passenger myPassenger = mapToPassengerRequest(request);
        passengerRepository.findById(myPassenger.getId()).orElseThrow(() -> new PassengerNotFoundException("Passenger with ID " + myPassenger.getId() + " not found."));
        myPassenger.setDeleted(true);

        return mapToPassengerResponse(myPassenger);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public FindDriverByIdResponse findDriver(FindDriverByIdRequest request) {
        if(request.getId() == null || request.getId().trim().isEmpty())throw new ValidateDriverException("Driver ID cannot be empty");
        Optional<Driver> findDriver = driverRepository.findById(request.getId());
        if(!findDriver.isPresent()) throw new DriverNotFoundException("Driver not found");

        Driver newDriver = mapToFindDriverRequest(request);
        driverRepository.findById(newDriver.getId());

        return mapToFindDriverResponse(newDriver);
    }


}
