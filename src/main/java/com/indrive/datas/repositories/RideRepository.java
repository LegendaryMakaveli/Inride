package com.indrive.datas.repositories;

import com.indrive.datas.models.Ride;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RideRepository extends MongoRepository<@NonNull Ride,@NonNull String> {
}
