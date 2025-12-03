package com.indrive.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document("Rides")
public class Ride {
    @Id
    private String id;
    private double rideFee;
    private String passengerId;
    private String destination;
    private LocalDateTime timeStamp;
    private String driverId;
    private RideStatus rideStatus;

}
