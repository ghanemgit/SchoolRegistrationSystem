package com.midproject.schoolregistrationsystem.Controller;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Model.Course;
import com.midproject.schoolregistrationsystem.Service.ApplicationUserServiceImp;
import com.midproject.schoolregistrationsystem.Service.CourseServiceImp;
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
    private ApplicationUserServiceImp applicationUserServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp ;




    @GetMapping("/{id}/courses")
    public String viewCourses(@PathVariable("id") Long id, Model model)
    {
        ApplicationUser student =applicationUserServiceImp.getApplicationUserById(id);
        List<Course> courses = student.getCourses();
        if(courses.isEmpty()) {
            return "redirect:/student/" + id + "/addCourses";
        }
        model.addAttribute("remove_id", id);
        model.addAttribute("courses", courses);
        return "Course/course-list";
    }

    @GetMapping("/{id}/addCourses")
    public String addCourses(@PathVariable("id") Long id, Model model)
    {
        List<Course> studentCourses = applicationUserServiceImp.getApplicationUserById(id).getCourses();
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
    public String addCourseToStudent(@PathVariable("sid") Long sid, @RequestParam("cid") Long cid)
    {
        ApplicationUser student = applicationUserServiceImp.getApplicationUserById(sid);
        Course course = courseServiceImp.findById(cid);
        student.addCourse(course);
        //applicationUserServiceImp.saveNewApplicationUser(student);
        course.addStudent(student);
        courseServiceImp.save(course);
        return "redirect:/student/"+sid+"/courses";
}

    @GetMapping("/{sid}/removeCourse")
    public String removeCourse(@PathVariable("sid") Long sid, @RequestParam("cid") Long cid)
    {
        ApplicationUser student = applicationUserServiceImp.getApplicationUserById(sid);
        Course course = courseServiceImp.findById(cid);
        student.removeCourse(course);
        //applicationUserServiceImp.saveNewApplicationUser(student);
        course.removeStudent(student);
        courseServiceImp.save(course);
        return "redirect:/student/"+sid+"/courses";
    }


}
