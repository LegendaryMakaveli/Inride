package com.indrive.datas.repositories;

import com.indrive.datas.models.RideRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RideRequestRepositiory extends MongoRepository<RideRequest,String> {
}
