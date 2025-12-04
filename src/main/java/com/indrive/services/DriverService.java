package com.indrive.services;

import com.indrive.dtos.requets.DriverRequest.*;
import com.indrive.dtos.responses.DriverRespone.RideApplicationResponse;
import com.indrive.dtos.responses.DriverRespone.StartRideResponse;
import com.indrive.dtos.responses.DriverRespone.ViewRideResponse;

import java.util.List;

public interface DriverService {
    RideApplicationResponse applyForRideRequest(RideApplicationRequest request);
    List<ViewRideResponse> viewAvailableRides(ViewRideRequest request);
    StartRideResponse startRide(StartRideRequest request);
    EndRideResponse endRide(EndRideRequest request);

}
