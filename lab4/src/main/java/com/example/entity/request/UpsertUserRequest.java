package com.example.entity.request;

import com.example.validation.ValidationMessage;
import com.example.validation.ValidationPattern;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class UpsertUserRequest {
    private String secondName;
    private String firstName;
    private String surname;
    private LocalDate birthDate;
    private boolean sex;
    private String passportSeries;
    @Pattern(message = ValidationMessage.PASSPORT_NUMBER,
            regexp = ValidationPattern.PASSPORT_NUMBER)
    private String passportNumber;
    private String identificationNumber;
    private String addressOfActualResidence;
    @Pattern(message = ValidationMessage.PHONE_NUMBER,
            regexp = ValidationPattern.PHONE_NUMBER)
    private String homePhoneNumber;
    @Pattern(message = ValidationMessage.PHONE_NUMBER,
            regexp = ValidationPattern.PHONE_NUMBER)
    private String mobilePhoneNumber;
}
