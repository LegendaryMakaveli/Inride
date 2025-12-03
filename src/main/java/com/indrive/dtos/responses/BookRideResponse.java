package com.indrive.dtos.responses;

import lombok.Data;

@Data
public class BookRideResponse {
    private String rideRequestId;
    private String destination;
    private double price;
}
