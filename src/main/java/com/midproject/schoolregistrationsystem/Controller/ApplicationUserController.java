package com.midproject.schoolregistrationsystem.Controller;

import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
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

        /*
        I created this method to take the role as string from the form and replace it by number of type long
        this is done to store the role of user into user_id-user_role table(1 represent the admin,
        2 represent the teacher and 3 represent the student
         */
        uRole = applicationUserService.stringRoleToLong(applicationUser.getUserRole());


        newApplicationUser.setRole(roleService.findRoleById(uRole));

        Authentication authentication = new UsernamePasswordAuthenticationToken(newApplicationUser, null, newApplicationUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        newApplicationUser.setPassword(passwordEncoder.encode(newApplicationUser.getPassword()));
        applicationUserService.saveNewApplicationUser(newApplicationUser);

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

        /*
        I created this method to take the role as string from the form and replace it by number of type long
        this is done to store the role of user into user_id-user_role table(1 represent the admin,
        2 represent the teacher and 3 represent the student
         */
        uRole = applicationUserService.stringRoleToLong(existingApplicationUser.getUserRole());


        existingApplicationUser.setRole(roleService.findRoleById(uRole));

        Authentication authentication = new UsernamePasswordAuthenticationToken(existingApplicationUser, null, existingApplicationUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        applicationUserService.updateApplicationUser(existingApplicationUser);
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

}
