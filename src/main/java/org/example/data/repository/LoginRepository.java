package org.example.data.repository;

import org.example.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository <User, String> {
    User findByUsername(User user);
}
