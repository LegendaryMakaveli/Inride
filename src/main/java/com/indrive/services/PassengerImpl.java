package com.indrive.services;

import com.indrive.ValidationClass.Validations;
import com.indrive.datas.models.Passenger;
import com.indrive.datas.models.Ride;
import com.indrive.datas.models.RideRequest;
import com.indrive.datas.models.RideStatus;
import com.indrive.datas.repositories.PassengerRepository;
import com.indrive.datas.repositories.RideRequestRepositiory;
import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.requets.BookRideRequest;
import com.indrive.dtos.responses.AdminResponses.RegisterPassengerResponse;
import com.indrive.dtos.responses.BookRideResponse;
import com.indrive.dtos.responses.CancelRideResponse;
import com.indrive.exceptions.PassengerDoesNotExistExceptions;
import com.indrive.exceptions.RideCancelException;
import com.indrive.exceptions.RideDoesNotRequestException;
import org.apache.el.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.indrive.utils.PassengerMapper.*;


@Service
public class
PassengerImpl implements PassengerService{
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private RideRequestRepositiory rideRequestRepositiory;





    @Override
    public BookRideResponse bookRide(BookRideRequest request) {
        validatePassenger(request.getPassengerId());
        RideRequest rideRequest = map(request);
        rideRequestRepositiory.save(rideRequest);
        return null;
    }

    @Override
    public CancelRideResponse cancelRide(String rideRequestId) {
        validateRideRequest(rideRequestId);
        validateRideStatus(rideRequestId);
        RideRequest request = searchForRideRequest(rideRequestId);
        request.setStatus(RideStatus.CANCELLED);
        return null;
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
