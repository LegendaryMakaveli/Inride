package com.indrive.datas.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Drivers")
public class Driver {
    @Id
    private String Id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String userName;
    private List<Ride> listOfRide;
    private boolean status;
    private Location currentLocation;
    private String plateNumber;
}
