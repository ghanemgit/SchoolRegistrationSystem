package com.midproject.schoolregistrationsystem.Controller;
import java.util.List;

import com.midproject.schoolregistrationsystem.Model.Course;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserService;
import com.midproject.schoolregistrationsystem.Service.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/courses")
@PreAuthorize("hasRole('TEACHER')")
public class CourseController{

    @Autowired
    private ApplicationUserService applicationUserService;
    @Autowired
    private CourseServiceImp courseService;

    @GetMapping("/students")
    public String listStudent(Model model){

        model.addAttribute("students", applicationUserService.findAllByRole("Student"));
        return "Admin/students";

    }


    @GetMapping
    public String findAll(Model model)
    {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "Course/course-list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model)
    {
        Course course = courseService.findById(id);
        model.addAttribute("course", course);
        return "Course/course-detail";
    }

    @GetMapping("/add")
    public String add(Model model)
    {
        Course theCourse = new Course();
        model.addAttribute("theCourse", theCourse);
        return "Course/course-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("theCourse") Course theCourse)
    {
        courseService.save(theCourse);
        return "redirect:/courses";
    }

}