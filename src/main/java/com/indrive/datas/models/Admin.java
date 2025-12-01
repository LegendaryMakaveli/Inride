package com.indrive.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Admin {
    @Id
    private String Id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
}

