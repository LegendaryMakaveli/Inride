package com.indrive.utils;

import com.indrive.datas.models.Admin;
import com.indrive.dtos.requets.RegisterAdminRequest;
import com.indrive.dtos.responses.RegisterAdminResponse;

public class Mapper {
    public static Admin mapRequestAdmin(RegisterAdminRequest registerAdminRequest) {
        Admin admin = new Admin();
        admin.setName(registerAdminRequest.getName());
        admin.setPassword(registerAdminRequest.getPassword());
        admin.setEmail(registerAdminRequest.getEmail());
        admin.setPhoneNumber(registerAdminRequest.getPhoneNumber());
        admin.setAddress(registerAdminRequest.getAddress());
        admin.setUsername(registerAdminRequest.getUsername());
        return admin;
    }

    public static RegisterAdminResponse mapResponseAdmin(Admin savedAdmin) {
        RegisterAdminResponse registerAdminResponse = new RegisterAdminResponse();
        registerAdminResponse.setUsername(savedAdmin.getUsername());
        registerAdminResponse.setMessage(savedAdmin.getName() + "registered successfully");
        return  registerAdminResponse;
    }
}

