package com.midproject.schoolregistrationsystem.Security;
import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("-------------------");
        System.out.println("This is username:" + username);
        System.out.println("---------------");
        ApplicationUser user = applicationUserRepository.findUserByUserName(username);

        if(user == null){
            System.out.print("User Not Found");
            throw new UsernameNotFoundException(username + "Not Found!");
        }
        return user;
    }
}