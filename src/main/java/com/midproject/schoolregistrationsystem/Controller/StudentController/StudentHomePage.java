package com.midproject.schoolregistrationsystem.Controller.StudentController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class StudentHomePage {

    @GetMapping("/StudentHomePage")
    public String getHome()
    {

        return "StudentHomePage";
    }

    @GetMapping("/courses")
    public String getCourses()
    {

        return "courses";
    }

    @GetMapping("/grades")
    public String getGrades()
    {

        return "grades";
    }

    @GetMapping("/logout")
    public String getOut()
    {

        return "index";
    }
}
