package com.xworkz.module.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class ModuleDTO {

    private int id;

    @NotNull
    @Size(min=3, max=10,message="name length must be in range of 3-10.")
    //@Min(3)
    private String name;

    @NotNull
    @Email(message = "Enter valid email id.")
    private String email;

    @NotNull
    @Digits(integer = 10, fraction = 0, message = "Phone Number should contain 10 digits.")
    private long phone;

    @NotNull
    @Email(message = "Alternate Email should be valid.")
    private String alterEmail;

    @NotNull
    @Digits(integer = 10, fraction = 0, message = "AltPhone Number should contain 10 digits.")
    private long alterPhone;

    @NotNull
    @Size(min=3, max=20, message = "Location must be between 3 to 20 characters.")
    private String location;

}
