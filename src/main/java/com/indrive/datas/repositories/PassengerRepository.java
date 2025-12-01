package com.indrive.datas.repositories;

import com.indrive.datas.models.Passenger;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<@NonNull Passenger,@NonNull String> {
}
