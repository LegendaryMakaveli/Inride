package com.indrive.services;

import com.indrive.dtos.requets.AdminRequests.RegisterPassengerRequest;
import com.indrive.dtos.responses.AdminResponses.RegisterPassengerResponse;

public interface PassengerService {

    RegisterPassengerResponse registerPassenger(RegisterPassengerRequest Request);



}
