package com.indrive.services;

import com.indrive.datas.models.RideApplication;
import com.indrive.datas.models.RideRequest;
import com.indrive.datas.models.RideStatus;
import com.indrive.datas.repositories.PassengerRepository;
import com.indrive.datas.repositories.RideRequestRepositiory;
import com.indrive.dtos.requets.BookRideRequest;
import com.indrive.dtos.responses.BookRideResponse;
import com.indrive.dtos.responses.CancelRideResponse;
import com.indrive.exceptions.PassengerDoesNotExistExceptions;
import com.indrive.exceptions.RideCancelException;
import com.indrive.exceptions.RideDoesNotRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.indrive.utils.Mapper.mapToCancelRideResponse;
import static com.indrive.utils.PassengerMapper.*;


@Service
public class PassengerImpl implements PassengerService{
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private RideRequestRepositiory rideRequestRepositiory;





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




    }

