package com.indrive.datas.models;

import com.indrive.dtos.requets.DriverRequest.RideApplicationRequest;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("RideRequests")
@Data
public class RideRequest {
    @Id
    private String id;
    private Map<String, RideApplication> appliedDrivers;
    private String destination;
    private String passengerId;
    private String passengerName;
    private RideStatus status;
    private Double price;
}
