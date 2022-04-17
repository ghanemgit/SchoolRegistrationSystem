package com.midproject.schoolregistrationsystem.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        ApplicationUser userDetails = (ApplicationUser) authentication.getPrincipal();

        String redirectURL = request.getContextPath();

        if (userDetails.hasRole("ADMIN")) {
            redirectURL = "profile";
        } else if (userDetails.hasRole("TEACHER")) {
            redirectURL = "teacher/profile";
        } else if (userDetails.hasRole("STUDENT")) {
            redirectURL = "student/profile";
        }

        response.sendRedirect(redirectURL);

    }

}
