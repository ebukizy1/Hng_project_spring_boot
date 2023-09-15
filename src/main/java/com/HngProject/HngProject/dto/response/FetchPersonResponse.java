package com.HngProject.HngProject.dto.response;

import com.HngProject.HngProject.data.models.Address;
import com.HngProject.HngProject.data.models.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FetchPersonResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Gender gender;
    private Address address;
}
