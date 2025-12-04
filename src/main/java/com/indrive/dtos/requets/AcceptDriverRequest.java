package com.indrive.dtos.requets;

import lombok.Data;

@Data
public class AcceptDriverRequest {
    private String driverId;
    private String rideRequestId;
}
