package com.xworkz.xworkzCommonModuleGunashreeB.service;

import com.xworkz.xworkzCommonModuleGunashreeB.dto.UserDTO;
import com.xworkz.xworkzCommonModuleGunashreeB.entity.UserEntity;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

public interface UserService {


    Set<ConstraintViolation<UserDTO>> save(UserDTO userDTO);
    String generatePassword(String password);
   Set<ConstraintViolation<UserDTO>>  updateDetails(String name,UserDTO userDTO,String filePath);
    UserEntity getAll(String email, String password);

    Long getNameCount(String name);

    Long getPhoneCount(Long phone);
    Long getAltEmailCount(String altEmail);
    Long getEmailCount(String email);

    Long getAltPhoneCount(Long altPhoneNumber);

UserEntity getAllByName(String name);


    String updatePassword(String name, String oldPassword, String newPassword,String confirmPassword);



}
