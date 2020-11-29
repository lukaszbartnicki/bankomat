package com.codeforce.firstboot.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Account")
@NoArgsConstructor
@AllArgsConstructor

public class AccountEntity implements Serializable {
    @Id
    @Column(unique = true)
    @NotNull
    private Long cardNumber;
    private long balance;
}
