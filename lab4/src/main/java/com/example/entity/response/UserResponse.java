package com.example.entity.response;

import com.example.entity.Citizenship;
import com.example.entity.City;
import lombok.Data;

import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserResponse {
    private String secondName;
    private String firstName;
    private String surname;
    private LocalDate birthDate;
    private boolean sex;
    private String passportSeries;
    private String passportNumber;
    private String identificationNumber;
    private List<City> cityOfResidence;
    private String addressOfActualResidence;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private List<Citizenship> citizenship;
}
