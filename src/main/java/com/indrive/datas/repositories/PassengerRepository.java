package com.indrive.datas.repositories;

import com.indrive.datas.models.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<Passenger, String> {
}
