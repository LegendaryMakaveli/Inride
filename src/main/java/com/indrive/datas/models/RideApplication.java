package com.indrive.datas.models;

import lombok.Data;

@Data
public class RideApplication {
    private String rideRequestId;
    private String driverId;
    private String driverName;
    private double driverPrice;
    private Location currentLocation;
}
