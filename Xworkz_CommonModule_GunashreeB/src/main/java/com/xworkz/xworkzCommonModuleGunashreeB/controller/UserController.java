package com.xworkz.xworkzCommonModuleGunashreeB.controller;

import com.xworkz.xworkzCommonModuleGunashreeB.dto.UserDTO;
import com.xworkz.xworkzCommonModuleGunashreeB.entity.UserEntity;
import com.xworkz.xworkzCommonModuleGunashreeB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.ConstraintViolation;

import java.util.Set;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService service;
    public UserController()
    {
        System.out.println("running UserController");
    }


    @PostMapping("/submit")
    public String onSubmit(UserDTO userDTO,Model model)
    {



        System.out.println(userDTO.toString());
        Set<ConstraintViolation<UserDTO>> constraintViolations=this.service.save(userDTO);
        if(constraintViolations.isEmpty())
            return "Success.jsp";
        model.addAttribute("error",constraintViolations);
        return "SignUp.jsp";
    }

    @PostMapping("/find")
    public String onLogin(@RequestParam String email, @RequestParam String password,  Model model)
    {
        System.out.println(email + " "+password);
        UserEntity entity=this.service.getAll(email,password);
        if(entity!=null){



            int loginCount=entity.getLoginCount();
            System.out.println(loginCount);

            if(loginCount==-1)
            {
                String userName=entity.getName();
                model.addAttribute("userName",userName);

                return "SetPassword.jsp";

            }
            else
            {
                return "Success.jsp";
            }
        }
        return "SignIn.jsp";

    }



}
