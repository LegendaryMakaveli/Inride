package com.indrive.services;

import com.indrive.datas.models.Driver;
import com.indrive.datas.models.Passenger;
import com.indrive.dtos.requets.AdminRequests.DeleteDriverRequest;
import com.indrive.dtos.requets.AdminRequests.DeletePassengerRequest;
import com.indrive.dtos.requets.AdminRequests.RegisterAdminRequest;
import com.indrive.dtos.requets.FindDriverByIdRequest;
import com.indrive.dtos.responses.AdminResponses.DeleteDriverResponse;
import com.indrive.dtos.responses.AdminResponses.DeletePassengerResponse;
import com.indrive.dtos.responses.AdminResponses.FindDriverByIdResponse;
import com.indrive.dtos.responses.AdminResponses.RegisterAdminResponse;

import java.util.List;

public interface AdminService {
    RegisterAdminResponse registerAdmin(RegisterAdminRequest registerAdminRequest);
    DeleteDriverResponse deleteDriver(DeleteDriverRequest request);
    DeletePassengerResponse deletePassenger(DeletePassengerRequest request);
    List<Driver> getAllDrivers();
    List<Passenger> getAllPassengers();
    FindDriverByIdResponse findDriver(FindDriverByIdRequest request);
}
