package com.indrive.services;

import com.indrive.datas.models.Driver;
import com.indrive.datas.repositories.DriverRepository;
import com.indrive.dtos.requets.RegisterDriverRequest;
import com.indrive.dtos.responses.RegisterDriverResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.indrive.utils.Mapper.mapAdminResponse;
import static com.indrive.utils.Mapper.mapDriverRequest;

@Service
public class DriverServiceImpl implements  DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public RegisterDriverResponse registerDriver(RegisterDriverRequest registerDriverRequest) {
        Driver driver = mapDriverRequest(registerDriverRequest);
        Driver savedDriver = driverRepository.save(driver);
        return mapAdminResponse(savedDriver);
    }
}
