package com.HngProject.HngProject.controller;

import com.HngProject.HngProject.dto.request.CreatePersonRequest;
import com.HngProject.HngProject.dto.request.UpdatePersonRequest;
import com.HngProject.HngProject.dto.response.CreatePersonResponse;
import com.HngProject.HngProject.dto.response.FetchPersonResponse;
import com.HngProject.HngProject.dto.response.UpdatePersonResponse;
import com.HngProject.HngProject.services.PersonServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonsController {

    @Autowired
    private PersonServices personServices;

    @PostMapping()
    public ResponseEntity<CreatePersonResponse> createPersonEndpoint(@RequestBody CreatePersonRequest createPersonRequest){
     CreatePersonResponse personResponse =  personServices.createPerson(createPersonRequest);
    return   ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
    }

    @PutMapping("/{user_id}")
    public  ResponseEntity<UpdatePersonResponse> updatePersonEndpoint(@PathVariable("user_id") String id,
                                                                      @RequestBody  UpdatePersonRequest updatePersonRequest){
              UpdatePersonResponse updatePerson =  personServices.updatePerson(id,updatePersonRequest);
              return ResponseEntity.ok(updatePerson);
    }
    @GetMapping("/{user_id}")
    public ResponseEntity<FetchPersonResponse> fetchPersonEndpoint(@PathVariable("user_id") String id){
       FetchPersonResponse personResponse = personServices.fetchPerson(id);
       return ResponseEntity.ok(personResponse);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> deletePersonEndpoint(@PathVariable("user_id") String id){
       String personResponse = personServices.deletePerson(id);
       return ResponseEntity.ok(personResponse);
    }



}
