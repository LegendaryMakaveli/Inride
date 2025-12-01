package com.indrive.services;

import com.indrive.dtos.requets.RegisterDriverRequest;
import com.indrive.dtos.responses.RegisterDriverResponse;

public interface DriverService {
    RegisterDriverResponse registerDriver(RegisterDriverRequest registerDriverRequest);
}
