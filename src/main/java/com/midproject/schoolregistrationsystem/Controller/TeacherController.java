package com.midproject.schoolregistrationsystem.Controller;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Model.Course;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserService;
import com.midproject.schoolregistrationsystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
@PreAuthorize("hasRole('TEACHER')")
public class TeacherController {


    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private CourseService courseService;




    /////////////////////////////////Get all courses the student enrolled to it from the teacher side\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @GetMapping("/{id}/courses")
    public String viewCourses(@PathVariable("id") Long id, Model model) {
        ApplicationUser student = applicationUserService.getApplicationUserById(id);
        List<Course> courses = student.getCourses();
        if (courses.isEmpty()) {
            return "redirect:/student/" + id + "/addCourses";
        }
        model.addAttribute("remove_id", id);
        model.addAttribute("courses", courses);
        return "Course/course-list";
    }
    /////////////////////////////////Get all courses the student enrolled to it from the teacher side\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    /////////////////////////////////Enroll the student in specific course\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @GetMapping("/{id}/addCourses")
    public String addCourses(@PathVariable("id") Long id, Model model) {
        List<Course> studentCourses = applicationUserService.getApplicationUserById(id).getCourses();
        List<Course> courses = courseService.findAll();
        List<Course> remainingCourses = new ArrayList<Course>();
        for (Course c : courses) {
            if (!studentCourses.contains(c)) {
                remainingCourses.add(c);
            }
        }
        model.addAttribute("courses", remainingCourses);
        model.addAttribute("add_id", id);
        return "Course/course-list";
    }


    @GetMapping("/{sid}/addCourse")
    public String addCourseToStudent(@PathVariable("sid") Long sid, @RequestParam("cid") Long cid) {
        ApplicationUser student = applicationUserService.getApplicationUserById(sid);
        Course course = courseService.findById(cid);
        student.addCourse(course);
        course.addStudent(student);
        courseService.save(course);
        return "redirect:/student/" + sid + "/courses";
    }

    /////////////////////////////////Enroll the student in specific course\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    /////////////////////////////////Unroll the student from specific course\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @GetMapping("/{sid}/removeCourse")
    public String removeCourse(@PathVariable("sid") Long sid, @RequestParam("cid") Long cid) {
        ApplicationUser student = applicationUserService.getApplicationUserById(sid);
        Course course = courseService.findById(cid);
        student.removeCourse(course);
        course.removeStudent(student);
        courseService.save(course);
        return "redirect:/student/" + sid + "/courses";
    }
    /////////////////////////////////Unroll the student from specific course\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


}
