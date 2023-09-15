package com.HngProject.HngProject.dto.response;

import com.HngProject.HngProject.data.models.Address;
import com.HngProject.HngProject.data.models.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePersonResponse {

    private String firstName;

    private String lastName;

    private Gender gender;

    private Address address;
}
