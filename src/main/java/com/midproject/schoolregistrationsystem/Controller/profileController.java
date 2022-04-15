package com.midproject.schoolregistrationsystem.Controller;

import com.midproject.schoolregistrationsystem.Model.User;
import com.midproject.schoolregistrationsystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class profileController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile")
    public String getUserprofile(Principal p, Model m){
        try {
            User currentUser = userRepository.findUserByUserName(p.getName());
            m.addAttribute("displayedUser", currentUser);
        } catch(Exception e){
            System.out.println(e);
        }
        return "profile";
    }
}
