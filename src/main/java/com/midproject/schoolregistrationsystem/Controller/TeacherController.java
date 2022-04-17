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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
@PreAuthorize("hasRole('TEACHER')")
public class TeacherController {

    @Autowired
    private ApplicationUserService applicationUserService;


    @GetMapping("/profile")
    public String getProfilePage(Model model){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ApplicationUser applicationUser = applicationUserService.findApplicationUserByUsername(userDetails.getUsername());

        model.addAttribute("username",userDetails.getUsername());
        model.addAttribute("firstName",applicationUser.getFirstName());
        model.addAttribute("lastName",applicationUser.getLastName());
        model.addAttribute("email",applicationUser.getEmail());
        model.addAttribute("degree",applicationUser.getDegree().getDisplayValue());
        model.addAttribute("age",applicationUser.getAge());
        model.addAttribute("gender",applicationUser.getGender().getDisplayValue());
        model.addAttribute("material",applicationUser.getMaterialStatus().getDisplayValue());
        model.addAttribute("position",applicationUser.getUserRole());

        return "Teacher/profile";

    }




}
