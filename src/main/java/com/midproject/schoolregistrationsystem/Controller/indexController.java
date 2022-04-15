package com.midproject.schoolregistrationsystem.Controller;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class indexController {

    @Autowired
    ApplicationUserService applicationUserService;

//    @GetMapping("/")
//    public String indexPage(Principal p, Model model){
//        if(p != null){
//            ApplicationUser applicationUser = applicationService.findUserByUsername(p.getName());
//            model.addAttribute("displayedUser", applicationUser);
//
//            List<ApplicationUser> applicationUsers = findAllExceptUserName(applicationUser);
//
//            model.addAttribute("users", applicationUsers);
//            return "index";
//        }else {
//            return "login";
//        }
//
//    }

    public List<ApplicationUser> findAllExceptUserName(ApplicationUser applicationUserName){
        List<ApplicationUser> applicationUsers = applicationUserService.getAllApplicationUser();
        applicationUsers.remove(applicationUserName);
        return applicationUsers;
    }

}
