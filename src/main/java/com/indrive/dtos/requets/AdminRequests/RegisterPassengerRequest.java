package com.indrive.dtos.requets.AdminRequests;

import lombok.Data;

@Data
public class RegisterPassengerRequest {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
}
