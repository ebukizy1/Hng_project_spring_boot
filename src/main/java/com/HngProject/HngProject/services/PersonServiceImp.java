package com.HngProject.HngProject.services;

import com.HngProject.HngProject.data.models.Address;
import com.HngProject.HngProject.data.models.Persons;
import com.HngProject.HngProject.data.repository.PersonRepository;
import com.HngProject.HngProject.dto.request.CreatePersonRequest;
import com.HngProject.HngProject.dto.request.UpdatePersonRequest;
import com.HngProject.HngProject.dto.response.CreatePersonResponse;
import com.HngProject.HngProject.dto.response.FetchPersonResponse;
import com.HngProject.HngProject.dto.response.UpdatePersonResponse;
import com.HngProject.HngProject.exception.PersonAlreadyExistException;
import com.HngProject.HngProject.exception.PersonNotExistException;
import com.HngProject.HngProject.utils.Mapper;
import com.HngProject.HngProject.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImp implements PersonServices {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public CreatePersonResponse createPerson(CreatePersonRequest createPersonRequest) {
        Persons persons = new Persons();
        Address address = new Address();
        Validator.validateCreatePerson(createPersonRequest);
        validatePersonAlreadyExist(createPersonRequest.getEmailAddress().toLowerCase());
        Validator.validateEmail(createPersonRequest.getEmailAddress().toLowerCase());
       Mapper.mapCreatePersonRequest(createPersonRequest, address, persons);
        var savedPerson = personRepository.save(persons);
        CreatePersonResponse personResponse = new CreatePersonResponse();
        Mapper.mapCreatePersonResponse(personResponse, savedPerson);

        return personResponse;
    }
    
    @Override
    public FetchPersonResponse fetchPerson(String personId) {
        Persons foundPerson = validatePersonWithEmail(personId);
        FetchPersonResponse fetchPersonResponse = new FetchPersonResponse();
        Mapper.mapFetchPersonResponse(fetchPersonResponse, foundPerson);
        return fetchPersonResponse;
    }
    

    @Override
    public UpdatePersonResponse updatePerson(String personId, UpdatePersonRequest personRequest) {
        Persons foundPerson = validatePersonWithEmail(personId);
        UpdatePersonResponse updatePersonResponse = new UpdatePersonResponse();
        Address address = new Address();
        Mapper.mapUpdatePerson(personRequest, foundPerson, address);
        foundPerson.setAddress(address);
        Persons savePerson = personRepository.save(foundPerson);
        Mapper.mapUpdatePersonResponse(updatePersonResponse, savePerson);
        return updatePersonResponse;

    }

    @Override
    public String deletePerson(String personId) {
        String message = "";
        Persons foundPerson = validatePersonWithEmail(personId);
        personRepository.delete(foundPerson);
        message = foundPerson.getEmailAddress() + " successfully deleted";
        return message;


    }

    public Persons validatePersonWithEmail(String email) {
        Optional<Persons> optionalPersons = personRepository.findByEmailAddress(email);
        if (optionalPersons.isEmpty()) throw new PersonNotExistException(email + "  does not exist");
        return optionalPersons.get();
    }

    public void validatePersonAlreadyExist(String email) {
        Optional<Persons> optionalPersons = personRepository.findByEmailAddress(email);
        if (optionalPersons.isPresent()) {
            throw new PersonAlreadyExistException(email + " emailAddress Already exist");
        }
    }

    
    }
