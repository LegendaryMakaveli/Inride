package com.indrive.services;

import com.indrive.dtos.requets.AdminRequests.DeleteDriverRequest;
import com.indrive.dtos.requets.AdminRequests.RegisterAdminRequest;
import com.indrive.dtos.responses.AdminResponses.DeleteDriverResponse;
import com.indrive.dtos.responses.AdminResponses.RegisterAdminResponse;

public interface AdminService {
    RegisterAdminResponse registerAdmin(RegisterAdminRequest registerAdminRequest);
    DeleteDriverResponse deleteDriver(DeleteDriverRequest request);
}
