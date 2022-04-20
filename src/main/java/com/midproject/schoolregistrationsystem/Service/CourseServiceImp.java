package com.midproject.schoolregistrationsystem.Service;

import com.midproject.schoolregistrationsystem.Model.Course;
import com.midproject.schoolregistrationsystem.Repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.getById(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
