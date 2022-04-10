package com.midproject.schoolregistrationsystem.Controller;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.security.Principal;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/")
    public String indexPage(Principal p, Model model){
        if(p != null){
            ApplicationUser user = applicationUserRepository.findUserByUserName(p.getName());
            model.addAttribute("displayedUser", user);

            List<ApplicationUser> users = findAllExceptUserName(user);

            model.addAttribute("users", users);
            return "index";
        }else {
            return "login";
        }

    }

    public List<ApplicationUser> findAllExceptUserName(ApplicationUser userName){
        List<ApplicationUser> user = applicationUserRepository.findAll();
        user.remove(userName);
        return user;
    }

}
