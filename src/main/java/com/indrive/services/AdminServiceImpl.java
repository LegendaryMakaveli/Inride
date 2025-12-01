package com.indrive.services;

import com.indrive.datas.models.Admin;
import com.indrive.datas.repositories.AdminRepository;
import com.indrive.dtos.requets.RegisterAdminRequest;
import com.indrive.dtos.responses.RegisterAdminResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.indrive.utils.Mapper.mapRequestAdmin;
import static com.indrive.utils.Mapper.mapResponseAdmin;


@Service
public class AdminServiceImpl implements  AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public RegisterAdminResponse registerAdmin(RegisterAdminRequest registerAdminRequest) {
        Admin admin = mapRequestAdmin(registerAdminRequest);
        Admin savedAdmin = adminRepository.save(admin);
        return mapResponseAdmin(savedAdmin);
    }
}
