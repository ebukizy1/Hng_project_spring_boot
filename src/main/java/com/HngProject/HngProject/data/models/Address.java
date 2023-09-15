package com.HngProject.HngProject.data.models;

import jakarta.persistence.*;
import lombok.*;


//@Entity(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Address {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
    private Long id;
    private String country;
    private String state;
    private String city;
    private String streetAddress;


}
