package com.indrive.services;

import com.indrive.dtos.requets.RegisterPassengerRequest;
import com.indrive.dtos.responses.RegisterPassengerResponse;

public interface PassengerService {

    RegisterPassengerResponse registerPassenger(RegisterPassengerRequest Request);



}
