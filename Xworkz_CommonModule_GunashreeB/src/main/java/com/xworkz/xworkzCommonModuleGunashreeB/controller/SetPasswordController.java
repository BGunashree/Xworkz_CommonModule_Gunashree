package com.xworkz.xworkzCommonModuleGunashreeB.controller;

import com.xworkz.xworkzCommonModuleGunashreeB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller

@RequestMapping("/")
public class SetPasswordController {

    @Autowired
    UserService service;
    public SetPasswordController()
    {
        System.out.println("runnign SetPasswordController");
    }

    @PostMapping("/setpassword")
    public String setNewPassword(@RequestParam String oldPassword,
                                 @RequestParam String newPassword,
                                 @RequestParam String confirmPassword,
                                 @RequestParam String name
                                , Model model) {



        System.out.println(name);
        String msg=service.updatePassword(name,oldPassword,newPassword,confirmPassword);

        if(msg!=null) {

            if (msg.equals("updated")) {

              //  String message = "password updated successfully";
              //  model.addAttribute("message", message);
                return "Success.jsp";
            } else if (msg.equals("new and confirm password is not same")) {
                String message1 = "confirm password does not match";
                model.addAttribute("message1", message1);
                System.out.println("its diff new and confirm");
                return "SetPassword.jsp";
            } else if (msg.equals("old password doesnt match")) {

                String message2 = "old password is incorrect";
                System.out.println("incorrect");
                model.addAttribute("message2", message2);
                return "SetPassword.jsp";

            }
        }

            return "SetPassword.jsp";
    }
}

