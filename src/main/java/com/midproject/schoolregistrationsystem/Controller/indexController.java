package com.midproject.schoolregistrationsystem.Controller;


import com.midproject.schoolregistrationsystem.Model.User;
import com.midproject.schoolregistrationsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class indexController {

    @Autowired
    UserService userService;

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

    public List<User> findAllExceptUserName(User userName){
        List<User> users = userService.getAllUsers();
        users.remove(userName);
        return users;
    }

}
