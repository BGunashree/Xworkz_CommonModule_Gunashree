package com.xworkz.xworkzCommonModuleGunashreeB.controller;

import com.xworkz.xworkzCommonModuleGunashreeB.constants.LocationEnum;
import com.xworkz.xworkzCommonModuleGunashreeB.dto.UserDTO;
import com.xworkz.xworkzCommonModuleGunashreeB.entity.UserEntity;
import com.xworkz.xworkzCommonModuleGunashreeB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.ConstraintViolation;


import java.io.IOException;
import java.nio.file.Files;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    @GetMapping("/signup")
    public  String onSignUp(Model model)
    {
        List<LocationEnum> listLocation=new ArrayList<>(Arrays.asList(LocationEnum.values()));

        model.addAttribute("listLocation",listLocation);

        return "SignUp.jsp";
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
                String userName= entity.getName();
                model.addAttribute("userName",userName);
                return "Success.jsp";
            }
        }
        return "SignIn.jsp";

    }
    @PostMapping("/updating")
    public String onUpdate( String userName, Model model)
    {
       // System.out.println(name);

        List<LocationEnum> listLocation=new ArrayList<>(Arrays.asList(LocationEnum.values()));

        model.addAttribute("listLocation",listLocation);
       // String userName=name;
        UserEntity entity=service.getAllByName(userName);
        model.addAttribute("entity",entity);
       model.addAttribute("userName",userName);
        return "Update.jsp";
    }

    @PostMapping("/update")
    public String onUpdating(@RequestParam("picture") MultipartFile multipartFile, @RequestParam String userName, UserDTO userDTO) throws IOException
    {
        System.out.println(userName);
        if(multipartFile.isEmpty())
        {
            Set<ConstraintViolation<UserDTO>>  set= service.updateDetails(userName,userDTO,null);
            if(set.isEmpty())
            {

                return "Success.jsp";
            }
        }
        else
        {
            System.out.println("multipartFile=="+multipartFile);
            System.out.println("multipartFile==OriginalFilename"+multipartFile.getOriginalFilename());
            System.out.println("multipartFile=="+multipartFile.getContentType());
            byte[] bytes=multipartFile.getBytes();
            Path path= Paths.get("C:\\projectx\\" + userName+ System.currentTimeMillis()+".jpg");
            Files.write(path,bytes);
            String filePath=path.getFileName().toString();
            System.err.println("path=="+filePath);
            Set<ConstraintViolation<UserDTO>>  set= service.updateDetails(userName,userDTO,filePath);
            if(set.isEmpty())
            {

                return "Success.jsp";
            }
        }


             return "Update.jsp";
    }



}
