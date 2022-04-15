package com.midproject.schoolregistrationsystem.Controller;


import com.midproject.schoolregistrationsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class loginController {


    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

//    @PostMapping("/login")
//    public String loginWithRole() {
//
//    return "redirect:/giveRole/{role}";
//    }
//
//    @GetMapping("/giveRole/{role}")
//    public String giveRoleToUser(@PathVariable String role, Model model, @ModelAttribute("user") ApplicationUser applicationUser) {
//
//        ApplicationUser thisUser = applicationService.getUserById(applicationUser.getId());
//
//        if (applicationService.getUserRoleByUsername(thisUser.getUsername()) == "ADMIN")
//            role = "admin";
//        if (applicationService.getUserRoleByUsername(thisUser.getUsername()) == "TEACHER")
//            role = "teacher";
//        if (applicationService.getUserRoleByUsername(thisUser.getUsername()) == "STUDENT")
//            role = "student";
//
//        return "index";
//    }

}