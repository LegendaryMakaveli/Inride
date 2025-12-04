package com.indrive.dtos.responses.AdminResponses;

import lombok.Data;

@Data
public class AcceptDriverResponse {
    private String driverName;
    private String phoneNumber;
    private String email;

}
