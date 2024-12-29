package com.xworkz.xworkzCommonModuleGunashreeB.service;

import com.xworkz.xworkzCommonModuleGunashreeB.dto.UserDTO;
import com.xworkz.xworkzCommonModuleGunashreeB.entity.UserEntity;
import com.xworkz.xworkzCommonModuleGunashreeB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Set<ConstraintViolation<UserDTO>> save(UserDTO userDTO) {

        UserEntity userEntity=new UserEntity();
        if(userDTO!=null) {
            System.out.println(userDTO.toString());
            String password = generatePassword(userDTO.getEmail());
            System.out.println(password);

            userEntity.setName(userDTO.getName());
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setPhone(userDTO.getPhone());
            userEntity.setAlternateEmail(userDTO.getAlternateEmail());
            userEntity.setAlternatePhone(userDTO.getAlternatePhone());
            userEntity.setLocation(userDTO.getLocation());
            userEntity.setPassword(passwordEncoder.encode(password));
            userEntity.setLoginCount(-1);
            ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
            Validator validator = vf.getValidator();
            Set<ConstraintViolation<UserDTO>> set = validator.validate(userDTO);
            if (set.isEmpty()) {
                boolean save = repository.save(userEntity);
                repository.saveEmail(userDTO.getEmail(), password);
            }

            return set;
        }
        return null;
    }

    @Override
    public String generatePassword(String email) {

        Random random=new Random();
        String password;
        String str[]=email.split("@");
        for(String s:str)
        {
            System.out.println(s);

        }
        StringBuilder rev=new StringBuilder();
        rev.append(str[0]);
        StringBuilder string=rev.length()>5? new StringBuilder(rev.substring(0, 5)) :rev;
        password= String.valueOf(string.reverse().append(100+random.nextInt(900)));

        return password;
    }

    @Override
    public UserEntity getAll(String email,String password)
    {
        UserEntity entity=repository.getAll(email);

        if(entity!=null)
        {


            if(passwordEncoder.matches(password,entity.getPassword()) && entity.getLoginCount()==-1)
            {
                System.out.println("matches");
                return entity;
            }
            else if(!(passwordEncoder.matches(password, entity.getPassword())) && (entity.getLoginCount()>=0 && entity.getLoginCount()<3)){


                repository.updateLoginCount(email,entity.getLoginCount());
                System.out.println("password entered is wrong");
                return null;


            }
            else if(!(passwordEncoder.matches(password, entity.getPassword())) && entity.getLoginCount()==3)
            {
                System.out.println("locked");
                return null;
            }
            else if(passwordEncoder.matches(password, entity.getPassword()) && (entity.getLoginCount()<3 && entity.getLoginCount()>-1))
            {
                boolean reset=repository.resetLoginCount(email,entity.getLoginCount());
                if(reset)
                   return entity;
                else
                    return null;
            }



        }


        return null;
    }

    @Override
    public Long getNameCount(String name) {

        Long count= repository.getNameCount(name);
        return count;
    }

    @Override
    public Long getPhoneCount(Long phone) {

        return repository.getPhoneCount(phone);
    }

    @Override
    public Long getAltEmailCount(String altEmail) {
        return repository.getAltEmailCount(altEmail);
    }

    @Override
    public Long getEmailCount(String email) {
        return repository.getEmailCount(email);
    }

    @Override
    public Long getAltPhoneCount(Long altPhoneNumber) {
        return repository.getAltPhoneCount(altPhoneNumber);
    }


    @Override
    public String updatePassword(String name, String oldPassword, String newPassword,String confirmPassword) {

       UserEntity entity= repository.getAllByName(name);

        if(entity!=null) {

            System.out.println(entity.getPassword());
            if (passwordEncoder.matches(oldPassword,entity.getPassword())) {
                if (newPassword.equals(confirmPassword)) {
                    int loginCount= entity.getLoginCount();
                    boolean updated = repository.updatePasswordAndLoginCount(name,passwordEncoder.encode(confirmPassword),loginCount);
                    if(updated) {

                        return "updated";
                    }
                    else
                    {
                        return "not updated";
                    }


                } else {
                    System.out.println("new password  and confirm password doesnt match");
                    return "new and confirm password is not same";

                }

            } else {
                System.out.println("old password doesnt match");
                return "old password doesnt match";
            }
        }

        return null;


    }




}
