package com.midproject.schoolregistrationsystem.Controller;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Model.Course;
import com.midproject.schoolregistrationsystem.Repositories.ApplicationUserRepository;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserService;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserServiceImp;
import com.midproject.schoolregistrationsystem.Service.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {

    @Autowired
    private ApplicationUserService applicationUserService;
    @Autowired
    private ApplicationUserServiceImp applicationUserServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp ;

    @GetMapping("/profile")
    public String getProfilePage(Model model){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ApplicationUser applicationUser = applicationUserService.findApplicationUserByUsername(userDetails.getUsername());

        model.addAttribute("username",userDetails.getUsername());
        model.addAttribute("firstName",applicationUser.getFirstName());
        model.addAttribute("lastName",applicationUser.getLastName());
        model.addAttribute("email",applicationUser.getEmail());
        model.addAttribute("age",applicationUser.getAge());
        model.addAttribute("gender",applicationUser.getGender().getDisplayValue());
        model.addAttribute("material",applicationUser.getMaterialStatus().getDisplayValue());
        model.addAttribute("position",applicationUser.getUserRole());

        return "Student/profile";

    }

    @GetMapping("/courses")
    public String getCourses(){

        return "Student/courses";
    }
    @GetMapping("/{id}/courses")
    public String viewCourses(@PathVariable("id") int id, Model model)
    {
        ApplicationUser student =applicationUserServiceImp.getApplicationUserById((long) id);
        List<Course> courses = student.getCourses();
        if(courses.isEmpty()) {
            return "redirect:/student/" + id + "/addCourses";
        }
        model.addAttribute("remove_id", id);
        model.addAttribute("courses", courses);
        return "Course/course-list";
    }

    @GetMapping("/{id}/addCourses")
    public String addCourses(@PathVariable("id") int id, Model model)
    {
        List<Course> studentCourses = applicationUserServiceImp.getApplicationUserById((long) id).getCourses();
        List<Course> courses = courseServiceImp.findAll();
        List<Course> remainingCourses = new ArrayList<Course>();
        for(Course c: courses)
        {
            if(!studentCourses.contains(c)) {
                remainingCourses.add(c);
            }
        }
        model.addAttribute("courses", remainingCourses);
        model.addAttribute("add_id", id);
        return "Course/course-list";
    }

    @GetMapping("/{sid}/addCourse")
    public String addCourse(@PathVariable("sid") int sid, @RequestParam("cid") int cid)
    {
        ApplicationUser student = applicationUserServiceImp.getApplicationUserById((long) sid);
        Course course = courseServiceImp.findById(cid);
        student.addCourse(course);
        applicationUserServiceImp.saveNewApplicationUser(student);
        course.addStudent(student);
        courseServiceImp.save(course);
        return "redirect:/student/"+sid+"/courses";
//        return "Admin/students" ;
}

    @GetMapping("/{sid}/removeCourse")
    public String removeCourse(@PathVariable("sid") int sid, @RequestParam("cid") int cid)
    {
        ApplicationUser student = applicationUserServiceImp.getApplicationUserById((long) sid);
        Course course = courseServiceImp.findById(cid);
        student.removeCourse(course);
        applicationUserServiceImp.saveNewApplicationUser(student);
        course.removeStudent(student);
        courseServiceImp.save(course);
        return "redirect:/student/"+sid+"/courses";
    }


}
