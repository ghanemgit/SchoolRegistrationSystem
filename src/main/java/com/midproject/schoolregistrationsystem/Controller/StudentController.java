package com.midproject.schoolregistrationsystem.Controller;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {

    @Autowired
    private ApplicationUserService applicationUserService;


    /////////////////////////////////Get all courses the student enrolled to it\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @GetMapping("/my-courses")
    public String getStudentCourses(Model model) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ApplicationUser student = applicationUserService.findApplicationUserByUsername(userDetails.getUsername());

        model.addAttribute("studentCourses", student.getCourses());

        return "Course/student-course";
    }
    /////////////////////////////////Get all courses the student enrolled to it\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


}
