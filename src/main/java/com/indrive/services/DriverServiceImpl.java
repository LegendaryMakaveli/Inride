package com.indrive.services;

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
    @Override
    public RideApplicationResponse applyForRideRequest(RideApplicationRequest request) {
        RideRequest rideRequest = searchForRideRequest(request.getRideRequestId());
        validateRideRequest(rideRequest);
        Driver foundDriver = searchForDriver(request.getDriverId());
        validateDriver(foundDriver);
        validateDriverStatus(foundDriver);
        rideRequest.setStatus(RideStatus.IN_PROGRESS);

        RideApplication application = map(request);
        rideRequest.getAppliedDrivers().put(request.getDriverId(),application);
        rideRequestRepositiory.save(rideRequest);
        return null;
    }

    @Override
    public List<ViewRideResponse> viewAvailableRides(ViewRideRequest request) {
       validateDriver(searchForDriver(request.getDriverId()));
        List<ViewRideResponse> listOfRequest = new ArrayList<>();
       for(RideRequest rideRequest: rideRequestRepositiory.findAll()){
           if(rideRequest.getStatus().equals(RideStatus.PENDING))
               listOfRequest.add(map(rideRequest));
       }
       return listOfRequest;
    }

    @Override
    public StartRideResponse startRide(StartRideRequest request) {
        Ride ride = searchForRide(request.getRideId());
        validateRide(ride);
        Driver driver = searchForDriver(request.getDriverId());
        validateDriver(driver);
        ride.setRideStatus(RideStatus.IN_PROGRESS);
        return map(rideRepository.save(ride));
    }

    @Override
    public EndRideResponse endRide(EndRideRequest request) {
        Ride ride = searchForRide(request.getRideId());
        validateRide(ride);
        ride.setRideStatus(RideStatus.COMPLETED);
        return mapResponse(rideRepository.save(ride));
    }


    private RideRequest searchForRideRequest(String rideRequestId) {
        return rideRequestRepositiory.findById(rideRequestId).isPresent() ? rideRequestRepositiory.findById(rideRequestId).get() : null;
    }
    private void validateRideRequest(RideRequest rideRequest) {
        if(rideRequest == null) throw new RideRequestDoesNotExit("Ride Request Does not Exist");
    }
    private Driver searchForDriver(String driverId) {
        return driverRepository.findById(driverId).isPresent() ? driverRepository.findById(driverId).get() : null;
    }
    private void validateDriver(Driver driver) {
        if(driver == null) throw new DriverNotFoundException("Driver Does not Exist");
    }
    private void validateDriverStatus(Driver driver) {
        if(driver.isAcceptanceStatus()) throw new BookingStatusExceptions("Can Not Apply For Ride");
    }
    private Ride searchForRide(String rideId) {
        return rideRepository.findById(rideId).isPresent() ? rideRepository.findById(rideId).get() : null;
    }
    private void validateRide(Ride ride){
        if(ride == null) throw new RideDoesExit("Ride Does not Exist");
    }
}
