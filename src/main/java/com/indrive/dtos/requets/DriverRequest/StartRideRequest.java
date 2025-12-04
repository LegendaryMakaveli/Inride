package com.indrive.dtos.requets.DriverRequest;

import com.indrive.datas.models.RideApplication;
import com.indrive.datas.models.RideStatus;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class StartRideRequest {
    private String rideId;
    private String driverId;
}
