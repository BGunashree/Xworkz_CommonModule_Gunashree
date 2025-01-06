package com.xworkz.xworkzCommonModuleGunashreeB.restController;

import com.xworkz.xworkzCommonModuleGunashreeB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserRestController {

    @Autowired
    private UserService service;

    @GetMapping(value="/name/{name}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String onName(@PathVariable String name){
        System.out.println("name="+name);
        Long count= this.service.getNameCount(name);
        if(count==0)
        {
            System.out.println("doest exist");
            return " ";

        }
        else {
            System.out.println("exist");
            return "name already exist";
        }
        // return null;
    }
    @GetMapping(value="/email/{email}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String onEmail(@PathVariable String email){
        System.out.println("email="+email);
        Long count= this.service.getEmailCount(email);
        if(count==0)
        {
            System.out.println("doest exist");
            return " ";
        }
        else {
            System.out.println("exist");
            return "email exists";
        }
        // return null;
    }
    @GetMapping(value = "/{field}/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onFieldChange(@PathVariable String field, @PathVariable String value) {
        System.out.println("Field: " + field + ", Value: " + value);

        Long count=0L;
        switch (field) {
//                case "email":
//                    count = service.countEmail(value);
//                    break;
            case "altEmail":


                count = service.getAltEmailCount(value);
                if(count==0)
                {
                    System.out.println("doest exist");
                    return " ";
                }
                else {
                    System.out.println("exist");
                    return "alternate email exists";
                }
            case "phone":
                Long phoneNumber = Long.parseLong(value);
                count = service.getPhoneCount(phoneNumber);
                if(count==0)
                {
                    System.out.println("doest exist");
                    return " ";
                }
                else {
                    System.out.println("exist");
                    return "phone number exists";
                }

            case "altPhone":
                Long altPhoneNumber = Long.parseLong(value);
                count = service.getAltPhoneCount(altPhoneNumber);
                if(count==0)
                {
                    System.out.println("doest exist");
                    return " ";
                }
                else {
                    System.out.println("exist");
                    return "alternate phone number exists";
                }
            default:
                System.out.println("Invalid field: " + field);
                return "{ \"status\": \"error\", \"message\": \"Invalid field\" }";
        }
      /*  if(count==0)
        {
            System.out.println("doest exist");
            return " ";
        }
        else {
            System.out.println("exist");
            return "exist";
        }*/


        //return null;
    }
    @GetMapping(value="/password/{password}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String onPassword(@PathVariable String password){
        System.out.println("password="+password);
       /* Long count= this.service.countEmail(password);
        if(count==0)
        {
            System.out.println("doest exist");
            return " ";
        }
        else {
            System.out.println("exist");
            return "exist";
        }*/
        return null;
    }
}








//            <input type="text" class="form-control" id="location" name="location"  placeholder="Enter your location" required>