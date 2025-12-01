package com.indrive.datas.repositories;


import com.indrive.datas.models.Admin;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminRepository extends MongoRepository< @NonNull Admin,@NonNull String> {
    Optional<Admin> findAdminByEmail(String email);
}
