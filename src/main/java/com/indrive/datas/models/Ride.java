package com.indrive.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Rides")
public class Ride {
    @Id
    private String id;
    private double rideFee;
    private String driverId;
    private String passengerId;
    private double rideDistance;
}
