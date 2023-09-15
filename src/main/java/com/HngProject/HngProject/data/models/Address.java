package com.HngProject.HngProject.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    @Id
    private String addressId;
    private String country;
    private String state;
    private String city;
    private String streetAddress;


}
