package com.xworkz.xworkzCommonModuleGunashreeB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserDTO {

    private int id;
    @Size(min=3,max=10,message = "characters in name must be of length 3 or less than 10")
    private String name;
    @Email
    @NotNull
    private String email;
    @Digits(integer = 10, fraction = 0)
    private long phone;
    @Email
    @NotNull
    private String alternateEmail;
    @Digits(integer = 10, fraction = 0)
    private long alternatePhone;
    private String location;
}
