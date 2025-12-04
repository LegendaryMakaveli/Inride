package com.indrive.dtos.requets.DriverRequest;

import lombok.Data;

@Data
public class EndRideResponse {
    private Double rideFee;
    private String rideEndTime;
}
