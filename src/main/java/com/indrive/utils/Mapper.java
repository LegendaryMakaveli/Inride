package com.indrive.utils;

import com.indrive.datas.models.Admin;
import com.indrive.datas.models.Driver;
import com.indrive.dtos.requets.RegisterAdminRequest;
import com.indrive.dtos.requets.RegisterDriverRequest;
import com.indrive.dtos.responses.RegisterAdminResponse;
import com.indrive.dtos.responses.RegisterDriverResponse;

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

    public static Driver mapDriverRequest(RegisterDriverRequest registerDriverRequest) {
        Driver driver = new Driver();
        driver.setName(registerDriverRequest.getName());
        driver.setEmail(registerDriverRequest.getEmail());
        driver.setPhone(registerDriverRequest.getPhone());
        driver.setAddress(registerDriverRequest.getAddress());
        driver.setPlateNumber(registerDriverRequest.getPlateNumber());
        driver.setStatus(true);
        return driver;
    }
    public static RegisterDriverResponse mapAdminResponse(Driver savedDriver) {
        RegisterDriverResponse registerDriverResponse = new RegisterDriverResponse();
        registerDriverResponse.setUserName(savedDriver.getUserName());
        registerDriverResponse.setMessage(savedDriver.getName() + "registered successfully");
        return  registerDriverResponse;
    }
}

