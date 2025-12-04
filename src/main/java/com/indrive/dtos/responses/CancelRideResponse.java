package com.indrive.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CancelRideResponse {
    private String rideRequestId;
    private String dateOFCancellation;
}
