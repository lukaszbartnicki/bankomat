package com.codeforce.firstboot.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResource {

    @NonNull
    private Long id;
    @NonNull
    private String city;
    @NonNull
    private String street;
    @NonNull
    private Long number;
}
