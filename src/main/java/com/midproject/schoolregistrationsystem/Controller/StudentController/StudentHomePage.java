package com.midproject.schoolregistrationsystem.Controller.StudentController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class StudentHomePage {

    @GetMapping("/student")
    public String getHome()
    {

        return "StudentHomePage";
    }
}
