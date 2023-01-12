package com.example.localibback.users;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    public List<User> findUsersBySurname(String surname);
    public List<User> findUsersByFirstname(String firstname);
}
