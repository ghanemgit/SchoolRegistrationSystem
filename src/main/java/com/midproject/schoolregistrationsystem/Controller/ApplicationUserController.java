package com.midproject.schoolregistrationsystem.Controller;

import com.midproject.schoolregistrationsystem.Model.Announcement;
import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Service.AnnouncementsService;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserService;
import com.midproject.schoolregistrationsystem.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class ApplicationUserController {

    @Autowired
    ApplicationUserService applicationUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AnnouncementsService announcementsService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDetailsService userDetailsService;





    ///////////////////////////Get User from the database according to roles\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @GetMapping("/users")
    public String listUsers(Model model){

        model.addAttribute("users", applicationUserService.getAllApplicationUser());
        return "Admin/users";

    }



    ///////////////////////////Get User from the database according to roles\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\





    ///////////////////////////Create New User and giving him the role\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @GetMapping("/users/new")
    public String createUserForm(Model model){

        ApplicationUser applicationUser = new ApplicationUser();
        model.addAttribute("user", applicationUser);
        return "Admin/createUser";
    }
    @PostMapping("/users/new")
    public String saveUser(@ModelAttribute("user") ApplicationUser applicationUser) {

        applicationUserService.saveNewApplicationUser(applicationUser);

        return "redirect:/users?added";

    }

    ///////////////////////////Create New User and giving him the role\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    ///////////////////////////////////////////Edit existing User \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){

        model.addAttribute("user", applicationUserService.getApplicationUserById(id));
        return "Admin/editUser";

    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("admin") ApplicationUser applicationUser){

        applicationUserService.updateApplicationUser(applicationUser,id);
        return "redirect:/users?updated";
    }
    ///////////////////////////////////////////Edit existing User \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    ///////////////////////////////////////////Delete existing User \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){

        applicationUserService.deleteApplicationUserById(id);

        return "redirect:/users?deleted";
    }

    ///////////////////////////////////////////Delete existing User \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    /////////////////////////////////Search on existing User in the database \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @RequestMapping("/search")
    public String searchInDB(Model model, @Param("keyword") String keyword) {
        List<ApplicationUser> listUsers = applicationUserService.listAllBySearch(keyword);
        model.addAttribute("users", listUsers);
        model.addAttribute("keyword", keyword);

        return "Admin/users";
    }
    /////////////////////////////////Search on existing User in the database \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\



    /////////////////////////////////Get all stuff about Announcements \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @GetMapping("/announcements")
    public String getAllAnnouncements(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username",userDetails.getUsername());
        model.addAttribute("announcements",announcementsService.getAllAnnouncements());
        return "Announcement/announcements";
    }

    @GetMapping("/announcement/add")
    public String getAnnouncementsForm(Model model){

        Announcement annoYhy = new Announcement();

        model.addAttribute("annoThy",annoYhy);

        return "Announcement/annoForm";
    }
    @PostMapping("/announcement/new")
    public String addNewAnnouncements(@ModelAttribute(name = "annoThy") Announcement announcement){

        announcementsService.addNewAnnouncements(announcement);

        return "redirect:/announcements?added";
    }

    @GetMapping("/announcement/edit/{id}")
    public String editAnnoForm(@PathVariable Long id, Model model){

        model.addAttribute("annoThy", announcementsService.getAnnouncementsById(id));
        return "Announcement/editAnno";

    }
    @PostMapping("/announcement/{id}")
    public String updateAnnouncements(@PathVariable Long id,@ModelAttribute(name = "annoThy") Announcement announcement){

        announcementsService.updateAnnouncements(announcement,id);

        return "redirect:/announcements?updated";
    }

    @GetMapping("/announcement/{id}")
    public String deleteAnnouncements(@PathVariable Long id){

        announcementsService.deleteAnnouncementsById(id);

        return "redirect:/announcements?deleted";
    }

    @RequestMapping("/search/anno")
    public String searchInDBAnno(Model model, @Param("keyword") String keyword) {
        List<Announcement> listAnno = announcementsService.listAllBySearch(keyword);
        model.addAttribute("announcements", listAnno);
        model.addAttribute("keyword", keyword);

        return "Announcement/announcements";
    }


    /////////////////////////////////Get all stuff about Announcements \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


}
