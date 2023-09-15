package com.HngProject.HngProject.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "person")
@Builder
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String emailAddress;
    @Enumerated
    private Gender gender;
//    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @Embedded
    private Address address;


}
