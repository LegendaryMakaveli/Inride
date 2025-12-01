package com.indrive.dtos.responses.AdminResponses;

import lombok.Data;

@Data
public class RegisterPassengerResponse {

    private String id;

    private String name;
    private String email;
    private String phone;
    private String message;
}
