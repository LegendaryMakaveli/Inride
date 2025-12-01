package com.indrive.datas.models;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Passenger {

    @Id
    private String id;

    private String name;
    private String email;
    private String phone;
    private String address;
    private Location location;
}
