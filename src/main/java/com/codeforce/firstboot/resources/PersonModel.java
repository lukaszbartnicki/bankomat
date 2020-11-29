package com.codeforce.firstboot.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {


    @NonNull
    private String name;
    @NonNull
    private String surname;
    @Max(value = 100, message = "max age is 100")
    private Long age;
    private Long phone;
    @Email
    private String email;
    private String city;
    private String street;
    private Long number;
    private long pin;


}