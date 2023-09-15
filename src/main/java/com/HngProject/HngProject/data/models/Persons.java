package com.HngProject.HngProject.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("person")
@Builder
public class Persons {
    @Id
    private String id;
    @Field(name = "firstName", order = 1)
    private String firstName;
    @Field(name = "lastName", order = 2)
    private String lastName;
    @Indexed(unique = true)
    @Field(name = "email", order = 3)
    private String emailAddress;
    @Field(name = "gender", order = 4)
    private Gender gender;
    @JsonIgnore
    private Address address;


}
