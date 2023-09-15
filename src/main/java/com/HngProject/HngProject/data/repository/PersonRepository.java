package com.HngProject.HngProject.data.repository;

import com.HngProject.HngProject.data.models.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Persons, Long> {
    Optional<Persons> findByEmailAddress(String emailAddress);
}