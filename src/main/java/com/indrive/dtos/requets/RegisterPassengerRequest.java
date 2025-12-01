package com.indrive.dtos.requets;

import lombok.Data;

@Data
public class RegisterPassengerRequest {

    private String name;
    private String email;
    private String phone;
    private String address;
}
