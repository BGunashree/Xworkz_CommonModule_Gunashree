package com.xworkz.xworkzCommonModuleGunashreeB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class UserDTO {

    private int id;
  //  @Size(min=3,max=10,message = "characters in name must be of length 3 or less than 10")
    @Pattern(
            regexp = "^[A-Za-z\\s]{3,50}$",
            message = "Name must be 3-50 characters long and contain only letters and spaces.")
   // @NotNull
    //@NotBlank
    @NotEmpty
    private String name;
    @Email
    @NotEmpty
    private String email;
    @Digits(integer = 10, fraction = 0)
    private long phone;
    @Email
    @NotEmpty
    private String alternateEmail;
    @Digits(integer = 10, fraction = 0, message="must be 10 digits")

    private long alternatePhone;
    private String location;
}
