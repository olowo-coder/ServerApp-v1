package com.example.serverappv1.repository;

import com.example.serverappv1.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends MongoRepository<Server, String>{
    Server findByIpAddress(String ipAddress);
}
