package com.billing.setu.repository;

import com.billing.setu.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<Users, Integer> {
    @Query("{'mobileNumber': ?0}")
    Users findByMobileNumber(String mobileNumber);
}
