package com.midproject.schoolregistrationsystem.Controller;

import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class profileController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/profile")
    public String getUserprofile(Principal p, Model m){
        try {
            ApplicationUser currentApplicationUser = applicationUserRepository.findApplicationUserByUsername(p.getName());
            m.addAttribute("displayedUser", currentApplicationUser);
        } catch(Exception e){
            System.out.println(e);
        }
        return "profile";
    }
}
