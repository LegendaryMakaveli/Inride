package com.indrive.dtos.responses.AdminResponses;



import lombok.Data;
@Data
public class FindDriverByIdResponse {
    private String driverName;
    private String driverId;
    private String driverEmail;
    private String driverPhoneNumber;
    private String driverPlateNumber;
}
