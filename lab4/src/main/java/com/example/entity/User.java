package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String secondName;
    private String firstName;
    private String surname;
    private LocalDate birthDate;
    private boolean sex;
    private String passportSeries;
    private String passportNumber;
    private String identificationNumber;
    @ManyToMany
    private Set<City> cityOfResidence;
    private String addressOfActualResidence;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    @ManyToMany
    private Set<Citizenship> citizenship;
}
