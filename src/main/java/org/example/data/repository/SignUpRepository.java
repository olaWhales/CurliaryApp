package org.example.data.repository;

import org.example.data.model.UserSignUp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends MongoRepository<UserSignUp, String> {
    UserSignUp findByUsername(String userName);
}
