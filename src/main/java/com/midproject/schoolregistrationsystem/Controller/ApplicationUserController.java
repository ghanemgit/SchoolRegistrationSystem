package com.midproject.schoolregistrationsystem.Controller;

import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @GetMapping("/users")
    public String listUsers(Model model){
        System.err.println("Hello from users endpoint");

        model.addAttribute("users", applicationUserService.getAllApplicationUser());
        return "Users/users";

    }

    @GetMapping("/users/new")
    public String createUserForm(Model model){

        //create student object to hold student data
        System.err.println("Welcome from users new endpoint");
        ApplicationUser applicationUser = new ApplicationUser();
        model.addAttribute("user", applicationUser);
        return "Users/createUser";
    }

    @PostMapping("/users/new")
    public String saveAdmin(@ModelAttribute("user") ApplicationUser applicationUser){
        applicationUserService.saveNewApplicationUser(applicationUser);
        return "redirect:/users?added";

    }




    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){

        model.addAttribute("user", applicationUserService.getApplicationUserById(id));
        return "Users/editUser";

    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("admin") ApplicationUser applicationUser, Model model){

        ApplicationUser existingApplicationUser = applicationUserService.getApplicationUserById(id);
        existingApplicationUser.setFirstName(applicationUser.getFirstName());
        existingApplicationUser.setLastName(applicationUser.getLastName());
        existingApplicationUser.setEmail(applicationUser.getEmail());
        existingApplicationUser.setAge(applicationUser.getAge());
        existingApplicationUser.setRole(applicationUser.getRole());
        existingApplicationUser.setDegree(applicationUser.getDegree());
        existingApplicationUser.setGender(applicationUser.getGender());
        existingApplicationUser.setMaterialStatus(applicationUser.getMaterialStatus());
        existingApplicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));

        applicationUserService.updateApplicationUser(existingApplicationUser);
        return "redirect:/users";
    }


    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){

        applicationUserService.deleteApplicationUserById(id);
        return "redirect:/users";
    }


    @GetMapping("/student")
    public String getStudentHome(){

        return "student";
    }

    @GetMapping("/teacher")
    public String getTeacherHome(){

        return "teacher";
    }


    @RequestMapping("/search")
    public String searchInDB(Model model, @Param("keyword") String keyword) {
        List<ApplicationUser> listUsers = applicationUserService.listAllBySearch(keyword);
        model.addAttribute("users", listUsers);
        model.addAttribute("keyword", keyword);

        return "Users/users";
    }

}
