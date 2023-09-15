package com.HngProject.HngProject.services;
import com.HngProject.HngProject.dto.request.*;
import com.HngProject.HngProject.dto.response.*;

public interface PersonServices {

    CreatePersonResponse createPerson(CreatePersonRequest createPersonRequest);
    FetchPersonResponse fetchPerson(String personId);
    UpdatePersonResponse updatePerson(String personId, UpdatePersonRequest personRequest);
    String deletePerson(String personId);


}
