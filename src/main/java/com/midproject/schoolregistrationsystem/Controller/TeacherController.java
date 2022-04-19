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



}
