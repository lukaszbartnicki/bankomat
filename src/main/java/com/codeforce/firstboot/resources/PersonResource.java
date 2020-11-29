package com.codeforce.firstboot.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResource {

    private Long id;
    private String name;
    private String surname;
    private Long age;
    private Long phone;
    private String email;
    private AddressResource address;
    private PasswordResource password;
    private AccountResource account;
}