package com.indrive.services;

import com.indrive.ValidationClass.Validations;
import com.indrive.datas.models.*;
import com.indrive.datas.repositories.DriverRepository;
import com.indrive.datas.repositories.RideRepository;
import com.indrive.datas.repositories.RideRequestRepositiory;
import com.indrive.dtos.requets.DriverRequest.*;
import com.indrive.dtos.responses.DriverRespone.RideApplicationResponse;
import com.indrive.dtos.responses.DriverRespone.StartRideResponse;
import com.indrive.dtos.responses.DriverRespone.ViewRideResponse;
import com.indrive.exceptions.BookingStatusExceptions;
import com.indrive.exceptions.DriverNotFoundException;
import com.indrive.exceptions.RideDoesExit;
import com.indrive.exceptions.RideRequestDoesNotExit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.indrive.utils.Mapper.mapResponse;
import static com.indrive.utils.PassengerMapper.map;
import static com.indrive.utils.Mapper.map;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private RideRequestRepositiory rideRequestRepositiory;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private Validations validate;


    @Override
    public RideApplicationResponse applyForRideRequest(RideApplicationRequest request) {
        RideRequest rideRequest = validate.searchForRideRequest(request.getRideRequestId());
        validate.validateRideRequest(rideRequest);

        Driver foundDriver = validate.searchForDriver(request.getDriverId());
        validate.validateLoginStatus(validate.searchForDriver(request.getDriverId()));

        validate.validateDriver(foundDriver);
        validate.validateDriverStatus(foundDriver);

        rideRequest.setStatus(RideStatus.IN_PROGRESS);
        RideApplication application = map(request);

        rideRequest.getAppliedDrivers().put(request.getDriverId(),application);
        rideRequestRepositiory.save(rideRequest);
        return null;
    }

    @Override
    public List<ViewRideResponse> viewAvailableRides(ViewRideRequest request) {
       validate.validateDriver(validate.searchForDriver(request.getDriverId()));
       validate.validateLoginStatus(validate.searchForDriver(request.getDriverId()));
        List<ViewRideResponse> listOfRequest = new ArrayList<>();
       for(RideRequest rideRequest: rideRequestRepositiory.findAll()){
           if(rideRequest.getStatus().equals(RideStatus.PENDING))
               listOfRequest.add(map(rideRequest));
       }
       return listOfRequest;
    }

    @Override
    public StartRideResponse startRide(StartRideRequest request) {
        Ride ride = validate.searchForRide(request.getRideId());
        validate.validateRide(ride);
        Driver driver = validate.searchForDriver(request.getDriverId());
        validate.validateLoginStatus(validate.searchForDriver(request.getDriverId()));
        validate.validateDriver(driver);
        ride.setRideStatus(RideStatus.IN_PROGRESS);
        return map(rideRepository.save(ride));
    }

    @Override
    public EndRideResponse endRide(EndRideRequest request) {
        validate.validateLoginStatus(validate.searchForDriver(request.getDriverId()));
        Ride ride = validate.searchForRide(request.getRideId());
        validate.validateRide(ride);
        ride.setRideStatus(RideStatus.COMPLETED);
        Driver rideDriver = validate.searchForDriver(ride.getDriverId());
        rideDriver.setAcceptanceStatus(false);
        driverRepository.save(rideDriver);
        return mapResponse(rideRepository.save(ride));
    }
}
