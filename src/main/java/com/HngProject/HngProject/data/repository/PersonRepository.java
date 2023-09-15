package com.HngProject.HngProject.data.repository;

import com.HngProject.HngProject.data.models.Persons;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<Persons, String> {
    Optional<Persons> findByEmailAddress(String emailAddress);
}