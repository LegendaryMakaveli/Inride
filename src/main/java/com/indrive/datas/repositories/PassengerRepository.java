package com.indrive.datas.repositories;

import com.indrive.datas.models.Passenger;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PassengerRepository extends MongoRepository<@NonNull Passenger,@NonNull String> {
    Optional<Passenger> findByEmail(String email);
}
