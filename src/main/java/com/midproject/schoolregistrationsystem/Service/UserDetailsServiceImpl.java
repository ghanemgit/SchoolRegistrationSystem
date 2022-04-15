package com.midproject.schoolregistrationsystem.Service;
import com.midproject.schoolregistrationsystem.Model.User;
import com.midproject.schoolregistrationsystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {



    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("-------------------");
        System.out.println("This is username:" + username);
        System.out.println("---------------");
        User account = userRepository.findUserByUserName(username);
        if(account == null){
            System.out.print("User Not Found");
            throw new UsernameNotFoundException(username + "Not Found!");
        }
        return account;
    }




}