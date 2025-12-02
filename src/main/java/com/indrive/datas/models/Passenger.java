package com.indrive.datas.models;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Passengers")
public class Passenger {

    @Id
    private String id;

    private String name;
    private String email;
    private String password;
    private boolean activeStatus = false;
    private String phone;
    private String address;
    private String password;
    private Location currentlocation;
    private boolean isDeleted;
}
