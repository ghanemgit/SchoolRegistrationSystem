package com.midproject.schoolregistrationsystem.Controller;

import com.midproject.schoolregistrationsystem.Model.User;
import com.midproject.schoolregistrationsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/users")
    public String listUsers(Model model){
        System.err.println("Hello from users endpoint");

        model.addAttribute("users", userService.getAllUsers());
        return "Users/users";

    }

    @GetMapping("/users/new")
    public String createUserForm(Model model){

        //create student object to hold student data
        User user = new User();
        model.addAttribute("user", user);
        return "Users/createUser";
    }

    @PostMapping("/users/new")
    public String saveAdmin(@ModelAttribute("user") User user){
        userService.saveNewUser(user);
        return "redirect:/users?added";

    }




    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){

        model.addAttribute("user", userService.getUserById(id));
        return "Users/editUser";

    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("admin") User user, Model model){

        User existingUser = userService.getUserById(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setDateOfBirth(user.getDateOfBirth());
        existingUser.setDegree(user.getDegree());
        existingUser.setGender(user.getGender());
        existingUser.setMaterialStatus(user.getMaterialStatus());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.updateUser(existingUser);
        return "redirect:/users";
    }


    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){

        userService.deleteUserById(id);
        return "redirect:/users";
    }





}
