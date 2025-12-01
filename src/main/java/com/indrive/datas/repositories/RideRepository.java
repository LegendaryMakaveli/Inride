package com.indrive.datas.repositories;

import com.indrive.datas.models.Ride;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RideRepository extends MongoRepository<Ride,String> {
}
