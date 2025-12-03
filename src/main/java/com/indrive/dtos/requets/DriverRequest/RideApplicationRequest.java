package com.indrive.dtos.requets.DriverRequest;

import lombok.Data;

@Data
public class RideApplicationRequest {
   private String rideRequestId;
   private String driverId;
   private String driverName;
   private double driverPrice;
}
