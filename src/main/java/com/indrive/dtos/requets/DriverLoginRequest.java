package com.indrive.dtos.requets;


import lombok.Data;

@Data
public class DriverLoginRequest {
    private String driverEmail;
    private String driverPassword;
}
