package com.indrive.dtos.requets;

import lombok.Data;

@Data
public class RegisterDriverRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String plateNumber;
    private String password;
}
