package com.indrive.dtos.responses.DriverRespone;

import com.indrive.datas.models.RideStatus;
import lombok.Data;

@Data
public class ViewRideResponse {
    private String id;
    private String destination;
    private String passengerId;
    private String passengerName;
    private RideStatus status;
    private Double price;
}
