package com.midproject.schoolregistrationsystem.Controller;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Service.AnnouncementsService;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {


    @Autowired
    private ApplicationUserService applicationUserService;

   @Autowired
   private AnnouncementsService announcementsService;

    @GetMapping("/profile")
    public String getProfilePage(Model model){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ApplicationUser applicationUser = applicationUserService.findApplicationUserByUsername(userDetails.getUsername());

        model.addAttribute("username",userDetails.getUsername());
        model.addAttribute("name",(applicationUser.getFirstName()+" "+applicationUser.getLastName()));
        model.addAttribute("email",applicationUser.getEmail());
        model.addAttribute("age",applicationUser.getAge());
        model.addAttribute("gender",applicationUser.getGender());
        model.addAttribute("material",applicationUser.getMaterialStatus());
        model.addAttribute("position",applicationUser.getUserRole());
        model.addAttribute("id",applicationUser.getId());
        model.addAttribute("degree",applicationUser.getDegree());

        model.addAttribute("announcements",announcementsService.getAllAnnouncements());


        return "profile";

    }




}
