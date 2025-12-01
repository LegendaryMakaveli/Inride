package com.indrive.utils;

import com.indrive.datas.models.Admin;
import com.indrive.datas.models.Driver;
import com.indrive.dtos.requets.AdminRequests.DeleteDriverRequest;
import com.indrive.dtos.requets.AdminRequests.RegisterAdminRequest;
import com.indrive.dtos.responses.AdminResponses.DeleteDriverResponse;
import com.indrive.dtos.responses.AdminResponses.RegisterAdminResponse;

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

    public static Driver mapToDeleteDriverRequest(DeleteDriverRequest request) {
        Driver myDriver = new Driver();
        myDriver.setId(request.getId());

        return myDriver;
    }

    public static DeleteDriverResponse mapToDeleteDriverResponse(Driver driver) {
        DeleteDriverResponse response = new DeleteDriverResponse();
        response.setMessage("Driver with ID " + driver.getId() + "\n" + "Name: " + driver.getName() + "\n" + "Plate Number: " + driver.getPlateNumber() + " has been deleted successfully.");

        return response;
    }
}

