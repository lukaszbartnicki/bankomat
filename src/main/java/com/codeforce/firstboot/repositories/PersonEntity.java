package com.codeforce.firstboot.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Person")
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    private Long age;
    private Long phone;
    private String email;

    @OneToOne(cascade = {CascadeType.ALL})
    private AddressEntity address;
    @OneToOne(cascade = {CascadeType.ALL})
    private PasswordEntity password;
    @OneToOne(cascade = {CascadeType.ALL})
    private AccountEntity account;
}
