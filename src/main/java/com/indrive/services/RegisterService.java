package com.indrive.services;

import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.requets.RegisterDriverRequest;
import com.indrive.dtos.responses.AdminResponses.RegisterPassengerResponse;
import com.indrive.dtos.responses.RegisterDriverResponse;

public interface RegisterService {
    RegisterDriverResponse registerDriver(RegisterDriverRequest request);
    RegisterPassengerResponse registerPassenger(RegisterPassengerRequest registerPassengerRequest);
}
