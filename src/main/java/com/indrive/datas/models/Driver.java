package com.indrive.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Drivers")
public class Driver {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private List<Ride> listOfRide;
    private boolean activeStatus = false;
    private boolean acceptanceStatus;
    private Location currentLocation;
    private String plateNumber;
    private boolean isDeleted;
}
