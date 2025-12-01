package com.indrive.services;

import com.ValidationClass.Validations;
import com.indrive.datas.models.Admin;
import com.indrive.datas.models.Driver;
import com.indrive.datas.repositories.AdminRepository;
import com.indrive.datas.repositories.DriverRepository;
import com.indrive.dtos.requets.AdminRequests.DeleteDriverRequest;
import com.indrive.dtos.requets.AdminRequests.RegisterAdminRequest;
import com.indrive.dtos.responses.AdminResponses.DeleteDriverResponse;
import com.indrive.dtos.responses.AdminResponses.RegisterAdminResponse;
import com.indrive.exceptions.AdminExceptions.AdminNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.indrive.utils.Mapper.*;


@Service
public class AdminServiceImpl implements  AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private Validations validate;



    @Override
    public RegisterAdminResponse registerAdmin(RegisterAdminRequest registerAdminRequest) {
        validate.adminPasswordValidation(registerAdminRequest);
        validate.adminRequestValidations(registerAdminRequest);
        adminRepository.findAdminByEmail(registerAdminRequest.getEmail()).ifPresent(existingAdmin -> {
            throw new AdminNotFoundException("Admin with email " + registerAdminRequest.getEmail() + " already exists.");
        });

        Admin admin = mapRequestAdmin(registerAdminRequest);
        Admin savedAdmin = adminRepository.save(admin);
        return mapResponseAdmin(savedAdmin);
    }

    @Override
    public DeleteDriverResponse deleteDriver(DeleteDriverRequest request) {
        Driver myDriver = mapToDeleteDriverRequest(request);
        driverRepository.findById(myDriver.getId()).orElseThrow(() -> new AdminNotFoundException("Driver with ID " + myDriver.getId() + " not found."));
        myDriver.setDeleted(true);
        return mapToDeleteDriverResponse(myDriver);
    }


}
