package com.indrive.services;

import com.indrive.datas.models.*;
import com.indrive.datas.repositories.DriverRepository;
import com.indrive.datas.repositories.PassengerRepository;
import com.indrive.datas.repositories.RideRepository;
import com.indrive.datas.repositories.RideRequestRepositiory;
import com.indrive.dtos.requets.AcceptDriverRequest;
import com.indrive.dtos.requets.BookRideRequest;
import com.indrive.dtos.responses.AdminResponses.AcceptDriverResponse;
import com.indrive.dtos.responses.BookRideResponse;
import com.indrive.dtos.responses.CancelRideResponse;
import com.indrive.exceptions.PassengerDoesNotExistExceptions;
import com.indrive.exceptions.RideCancelException;
import com.indrive.exceptions.RideDoesNotRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.indrive.utils.Mapper.*;
import static com.indrive.utils.PassengerMapper.*;


@Service
public class
PassengerImpl implements PassengerService{
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private RideRequestRepositiory rideRequestRepositiory;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RideRepository rideRepository;





    @Override
    public BookRideResponse bookRide(BookRideRequest request) {
        validatePassenger(request.getPassengerId());
        RideRequest rideRequest = map(request);
        return mapRideResponse(rideRequestRepositiory.save(rideRequest));
    }

    @Override
    public CancelRideResponse cancelRide(String rideRequestId) {
        validateRideRequest(rideRequestId);
        validateRideStatus(rideRequestId);
        RideRequest request = searchForRideRequest(rideRequestId);
        request.setStatus(RideStatus.CANCELLED);
        return mapToCancelRideResponse(request);
    }

    @Override
    public Map<String, RideApplication> viewAppliedDrivers(String rideRequestId) {
        RideRequest rideRequest = searchForRideRequest(rideRequestId);
        validateRideRequest(rideRequestId);
        return rideRequest.getAppliedDrivers();
    }

    @Override
    public AcceptDriverResponse acceptDriverRequest(AcceptDriverRequest request) {
        validateRideRequest(request.getRideRequestId());
        RideRequest rideRequest = searchForRideRequest(request.getRideRequestId());
      Driver updatedStatusDriver = setDriverStatus(request.getDriverId());
      setRideRequestStatus(rideRequest);

      addRideToAcceptedDriverList(createRide(rideRequest,updatedStatusDriver.getId()));
       return map(driverRepository.save(updatedStatusDriver));
    }

    private Ride createRide(RideRequest rideRequest,String driverId) {
        Ride ride = mapRide(rideRequest);
        ride.setDriverId(driverId);
        ride.setRideFee(getAcceptedDriverFee(rideRequest,ride.getDriverId()));
        return rideRepository.save(ride);
    }

    private void addRideToAcceptedDriverList(Ride ride){
        searchForDriver(ride.getDriverId()).getListOfRide().add(ride);
    }
    private double getAcceptedDriverFee(RideRequest rideRequest,String driverId) {
        RideApplication driverRideApplication = rideRequest.getAppliedDrivers().get(driverId);
        return driverRideApplication.getDriverPrice();
    }

    private void setRideRequestStatus(RideRequest request) {
        request.setStatus(RideStatus.ACCEPTED);
        rideRequestRepositiory.save(request);
    }

    private Driver setDriverStatus(String driverId) {
        Driver driver = searchForDriver(driverId);
        driver.setAcceptanceStatus(true);
        return driver;
    }


    private void validatePassenger(String id){
        if(!passengerRepository.existsById(id)) throw new PassengerDoesNotExistExceptions("Passenger Does not Exist");
    }
    private void validateRideRequest(String id){
        if(!rideRequestRepositiory.existsById(id)) throw new RideDoesNotRequestException("Ride Does Not Exists");
    }
    private void validateRideStatus(String id){
        RideRequest request = searchForRideRequest(id);
        if(request.getStatus() == RideStatus.IN_PROGRESS) throw new RideCancelException("Ride Cannot be Cancelled");
    }
    private RideRequest searchForRideRequest(String id){
        return rideRequestRepositiory.findById(id).isPresent() ? rideRequestRepositiory.findById(id).get() : null;
    }
    private Driver searchForDriver(String id){
       return driverRepository.findById(id).isPresent() ?driverRepository.findById(id).get() : null;
    }




    }

