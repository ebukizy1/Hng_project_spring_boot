package com.HngProject.HngProject.dto.request;

import com.HngProject.HngProject.data.models.Address;
import com.HngProject.HngProject.data.models.Gender;

import lombok.*;


@Getter
@Setter

public class CreatePersonRequest {

    private String firstName;

    private String lastName;

    private String emailAddress;

    private Gender gender;
    private Address address;
}
