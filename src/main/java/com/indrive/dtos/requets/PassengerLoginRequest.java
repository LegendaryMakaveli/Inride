package com.indrive.dtos.requets;


import lombok.Data;

@Data
public class PassengerLoginRequest {
    private String passengerEmail;
    private String passengerPassword;
}
