package com.indrive.services;

import com.indrive.dtos.requets.BookRideRequest;
import com.indrive.dtos.responses.BookRideResponse;
import com.indrive.dtos.responses.CancelRideResponse;

public interface PassengerService {
    BookRideResponse bookRide(BookRideRequest request);
    CancelRideResponse cancelRide(String rideRequestId);
}
