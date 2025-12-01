package com.indrive.dtos.requets;

import com.indrive.datas.models.RideStatus;
import lombok.Data;

@Data
public class BookRideRequest {
    private String destination;
    private String passengerId;
    private String passengerName;
    private RideStatus status;
    private double fee;
}
