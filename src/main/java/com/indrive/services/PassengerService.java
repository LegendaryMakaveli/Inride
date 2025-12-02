package com.indrive.services;

import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.requets.BookRideRequest;
import com.indrive.dtos.responses.AdminResponses.RegisterPassengerResponse;
import com.indrive.dtos.responses.BookRideResponse;
import com.indrive.dtos.responses.CancelRideResponse;

public interface PassengerService {

//    RegisterPassengerResponse registerPassenger(RegisterPassengerRequest Request);
    BookRideResponse bookRide(BookRideRequest request);
    CancelRideResponse cancelRide(String rideRequestId);

}
