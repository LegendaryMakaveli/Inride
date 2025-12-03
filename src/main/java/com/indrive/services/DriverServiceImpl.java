package com.indrive.services;

import com.indrive.datas.models.Driver;
import com.indrive.datas.models.RideApplication;
import com.indrive.datas.models.RideRequest;
import com.indrive.datas.models.RideStatus;
import com.indrive.datas.repositories.DriverRepository;
import com.indrive.datas.repositories.RideRequestRepositiory;
import com.indrive.dtos.requets.DriverRequest.RideApplicationRequest;
import com.indrive.dtos.requets.DriverRequest.StartRideRequest;
import com.indrive.dtos.requets.DriverRequest.ViewRideRequest;
import com.indrive.dtos.responses.DriverRespone.RideApplicationResponse;
import com.indrive.dtos.responses.DriverRespone.StartRideResponse;
import com.indrive.dtos.responses.DriverRespone.ViewRideResponse;
import com.indrive.exceptions.DriverNotFoundException;
import com.indrive.exceptions.RideRequestDoesNotExit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.indrive.utils.PassengerMapper.map;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private RideRequestRepositiory rideRequestRepositiory;
    @Autowired
    private DriverRepository driverRepository;
    @Override
    public RideApplicationResponse applyForRideRequest(RideApplicationRequest request) {
        RideRequest rideRequest = searchForRideRequest(request.getRideRequestId());
        validateRideRequest(rideRequest);
        Driver acceptedDriver = searchForDriver(request.getDriverId());
        validateDriver(acceptedDriver);
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
}
