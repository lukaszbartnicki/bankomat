package com.codeforce.firstboot.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResource {

    @NonNull
    private Long id;
    @NonNull
    private long pin;
}
