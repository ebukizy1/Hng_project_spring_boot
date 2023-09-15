package com.HngProject.HngProject.dto.response;

import com.HngProject.HngProject.data.models.Address;
import com.HngProject.HngProject.data.models.Gender;

import lombok.*;

@Getter
@Setter
@ToString
public class CreatePersonResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String message;

}
