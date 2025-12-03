package com.indrive.services;

import com.indrive.datas.models.Ride;
import com.indrive.datas.models.RideApplication;
import com.indrive.dtos.requets.BookRideRequest;
import com.indrive.dtos.responses.BookRideResponse;
import com.indrive.dtos.responses.CancelRideResponse;

import java.util.List;
import java.util.Map;

public interface PassengerService {


    BookRideResponse bookRide(BookRideRequest request);
    CancelRideResponse cancelRide(String rideRequestId);
    Map<String ,RideApplication> viewAppliedDrivers(String rideRequestId);

}
