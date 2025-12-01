package com.indrive.dtos.requets;

import lombok.Data;

@Data
public class RegisterAdminRequest {
    private String username;
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    private String address;
}
