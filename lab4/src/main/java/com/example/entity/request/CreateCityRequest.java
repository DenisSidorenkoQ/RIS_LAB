package com.example.entity.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCityRequest {
    @NotNull
    @NotBlank
    private String name;
}
