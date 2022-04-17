package com.midproject.schoolregistrationsystem.Controller;

import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Model.Role;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserService;
import com.midproject.schoolregistrationsystem.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class ApplicationUserController {

    @Autowired
    ApplicationUserService applicationUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/users")
    public String listUsers(Model model){
        System.err.println("Hello from users endpoint");

        model.addAttribute("users", applicationUserService.getAllApplicationUser());
        return "Users/users";

    }
    @GetMapping("/students")
    public String listStudent(Model model){
        System.err.println("Hello from Student endpoint");

        model.addAttribute("users", applicationUserService.findAllByRole("Student"));
        return "Users/students";

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
    public String saveAdmin(@ModelAttribute("user") ApplicationUser applicationUser) {
        Long uRole=0L;
        ApplicationUser newApplicationUser = new ApplicationUser(
                applicationUser.getUsername()
                ,applicationUser.getPassword()
                ,applicationUser.getFirstName()
                ,applicationUser.getLastName()
                ,applicationUser.getGender()
                ,applicationUser.getAge()
                ,applicationUser.getEmail()
                , applicationUser.getMaterialStatus()
                ,applicationUser.getDegree()
                ,applicationUser.getUserRole());


        switch (applicationUser.getUserRole()){
            case "Admin":
                uRole=1L;
                break;
            case "Teacher":
                uRole=2L;
                break;
            case "Student":
                uRole=3L;
                break;
        }

        newApplicationUser.setRole(roleService.findRoleById(uRole));

        Authentication authentication = new UsernamePasswordAuthenticationToken(newApplicationUser, null, newApplicationUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        newApplicationUser.setPassword(passwordEncoder.encode(newApplicationUser.getPassword()));
        applicationUserService.saveNewApplicationUser(newApplicationUser);

        return "redirect:/users?added";

    }





    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){

        model.addAttribute("user", applicationUserService.getApplicationUserById(id));
        return "Users/editUser";

    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("admin") ApplicationUser applicationUser, Model model){
        Long uRole=0L;


        ApplicationUser existingApplicationUser = applicationUserService.getApplicationUserById(id);
        existingApplicationUser.setFirstName(applicationUser.getFirstName());
        existingApplicationUser.setLastName(applicationUser.getLastName());
        existingApplicationUser.setEmail(applicationUser.getEmail());
        existingApplicationUser.setAge(applicationUser.getAge());
        existingApplicationUser.setUserRole(applicationUser.getUserRole());
        existingApplicationUser.setDegree(applicationUser.getDegree());
        existingApplicationUser.setGender(applicationUser.getGender());
        existingApplicationUser.setMaterialStatus(applicationUser.getMaterialStatus());
        existingApplicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));



        switch (existingApplicationUser.getUserRole()){
            case "Admin":
                uRole=1L;
                break;
            case "Teacher":
                uRole=2L;
                break;
            case "Student":
                uRole=3L;
                break;
        }

        existingApplicationUser.setRole(roleService.findRoleById(uRole));

        Authentication authentication = new UsernamePasswordAuthenticationToken(existingApplicationUser, null, existingApplicationUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        applicationUserService.updateApplicationUser(existingApplicationUser);
        return "redirect:/users";
    }


    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){

        applicationUserService.deleteApplicationUserById(id);

        return "redirect:/users?deleted";
    }


    @GetMapping("/student")
    public String getStudentHome(){

        return "student";
    }

    @GetMapping("/teacher")
    public String getTeacherHome(){

        return "teacher";
    }

    @GetMapping("/test")
    public String getTestHome(){

        return "test";
    }

    @RequestMapping("/search")
    public String searchInDB(Model model, @Param("keyword") String keyword) {
        List<ApplicationUser> listUsers = applicationUserService.listAllBySearch(keyword);
        model.addAttribute("users", listUsers);
        model.addAttribute("keyword", keyword);

        return "Users/users";
    }

}
