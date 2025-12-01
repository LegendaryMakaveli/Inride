package com.indrive.datas.repositories;

import com.indrive.datas.models.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository  extends MongoRepository<Driver,String> {

}
