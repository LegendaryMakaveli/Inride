package com.indrive.services;

import com.indrive.dtos.requets.RegisterAdminRequest;
import com.indrive.dtos.responses.RegisterAdminResponse;

public interface AdminService {
    RegisterAdminResponse registerAdmin(RegisterAdminRequest registerAdminRequest);
}
