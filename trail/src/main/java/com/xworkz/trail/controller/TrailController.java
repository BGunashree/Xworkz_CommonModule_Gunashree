package com.xworkz.trail.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TrailController {


    public TrailController()
    {
        System.out.println("running TrailController");
    }

    @PostMapping("/submit")
    public String onSave()
    {
        return "SignUp.jsp";
    }
}
