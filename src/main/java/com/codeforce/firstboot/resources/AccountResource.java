package com.codeforce.firstboot.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResource {

    @NonNull
    private Long cardNumber;
    private long balance;
}
