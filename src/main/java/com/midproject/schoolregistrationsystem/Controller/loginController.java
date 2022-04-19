package com.midproject.schoolregistrationsystem.Controller;


import com.midproject.schoolregistrationsystem.Service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class loginController {




    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }


    @GetMapping("/")
    public String getHome(){

        return "redirect:/login";
    }

}