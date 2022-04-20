package com.midproject.schoolregistrationsystem;



import com.midproject.schoolregistrationsystem.Model.Course;
import com.midproject.schoolregistrationsystem.Model.Role;
import com.midproject.schoolregistrationsystem.Repositories.ApplicationUserRepository;
import com.midproject.schoolregistrationsystem.Repositories.CourseRepository;
import com.midproject.schoolregistrationsystem.Repositories.RoleRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class RepositoriesTest {
    @Autowired
    RoleRepository repo ;


    @Autowired
    CourseRepository courseServiceImp ;

    @Autowired
    ApplicationUserRepository applicationUserServiceImp;
    @Test
    public void createTest (){
        Role admin =new Role("ADMIN");
        Role teacher =new Role("TEACHER");
        Role student =new Role("STUDENT");
        repo.saveAll(List.of(admin,teacher,student));
        List<Role> roleList =repo.findAll();
        assertEquals(roleList.size(),6);
        // because there are three roles in data.sql so 3+3=6
    }
    @Test
    public void findUser (){

        assertNotNull(applicationUserServiceImp.findAll());
    }
    @Test
    public void findCourse (){
        Course course =new Course("math","science");
        courseServiceImp.save(course);
        assertNotNull(courseServiceImp.findById(1L));
    }



}

