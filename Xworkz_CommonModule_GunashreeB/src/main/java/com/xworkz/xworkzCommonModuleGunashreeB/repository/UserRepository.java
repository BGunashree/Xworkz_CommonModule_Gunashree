package com.xworkz.xworkzCommonModuleGunashreeB.repository;

import com.xworkz.xworkzCommonModuleGunashreeB.dto.UserDTO;
import com.xworkz.xworkzCommonModuleGunashreeB.entity.UserEntity;

import java.util.List;

public interface UserRepository {


    boolean save(UserEntity userEntity);

    UserEntity getAll(String email);

    Long getNameCount(String name);


    Long countField(String queryName, String paramName, Object value);
    Long getPhoneCount(Long phone);
    Long getAltEmailCount(String email);
    Long getEmailCount(String email);

    Long getAltPhoneCount(Long altPhoneNumber);

   boolean updateDetails(String name,UserDTO dto,String filePath);

    UserEntity getAllByName(String name);

    boolean updatePasswordAndLoginCount(String name,String confirmPassword,int
            loginCount);

    void updateLoginCount(String email,int loginCount);

    boolean resetLoginCount(String email, int loginCount);

    boolean saveEmail(String email, String password);
}
