package com.midproject.schoolregistrationsystem.Service;
import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Repositories.ApplicationUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {



    private final ApplicationUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("-------------------");
        System.out.println("This is username:" + username);
        System.out.println("---------------");
        ApplicationUser account = applicationUserRepository.findApplicationUserByUserName(username);
        if(account == null){
            System.out.print("User Not Found");
            throw new UsernameNotFoundException(username + "Not Found!");
        }
        return account;
    }




}