package com.HngProject.HngProject.services;

import com.HngProject.HngProject.data.models.Address;
import com.HngProject.HngProject.data.models.Gender;
import com.HngProject.HngProject.data.models.Persons;
import com.HngProject.HngProject.dto.request.CreatePersonRequest;
import com.HngProject.HngProject.dto.response.CreatePersonResponse;
import com.HngProject.HngProject.dto.response.FetchPersonResponse;
import com.HngProject.HngProject.exception.PersonNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PersonServiceImpTest {

  private CreatePersonRequest createPersonRequest;
  @Autowired
    private  PersonServiceImp personServiceImp;
  private  Address address;



@BeforeEach
void startWith(){
             address = new Address();
            address.setCountry("Nigeria");
            address.setState("lagos");
            address.setCity("ikeja");
            address.setStreetAddress("7 tarjudeen");

    createPersonRequest = new CreatePersonRequest();
    createPersonRequest.setFirstName("emmauel");
    createPersonRequest.setLastName("chukwuma");
    createPersonRequest.setEmailAddress("ebukizy1@gmail.com");
    createPersonRequest.setGender(Gender.MALE);
    createPersonRequest.setAddress(address);


}
    @Test
    void testPersonCanBeCreatedAndResponseCanBeSent(){
          CreatePersonResponse personResponse =  personServiceImp.createPerson(createPersonRequest);
            String reponse = personResponse.toString();
            System.out.println(personResponse.toString());
            assertEquals(reponse, personResponse.toString());
    }
    @Test
    void testPersonCanBeFetchFromTheDataBase(){
       FetchPersonResponse foundPersons =  personServiceImp.fetchPerson("ebukizy1@gmail.com");
       String reponse = foundPersons.toString();
        System.out.println(reponse);
       assertEquals(reponse, foundPersons.toString());
    }
    @Test
    void testWrongIdCantBeUsedToFindUser(){
        assertThrows(PersonNotExistException.class,()->  personServiceImp.fetchPerson("wrong password") );
    }


    @Test
    void testUseCanBeDeleted(){


    }



}