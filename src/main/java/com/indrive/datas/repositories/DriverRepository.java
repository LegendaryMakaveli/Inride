package com.indrive.datas.repositories;

import com.indrive.datas.models.Driver;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DriverRepository  extends MongoRepository<@NonNull Driver,@NonNull String> {
    Optional<Driver> findDriverByPlateNumber(String plateNumber);
}
