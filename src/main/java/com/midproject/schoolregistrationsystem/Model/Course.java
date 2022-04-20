package com.midproject.schoolregistrationsystem.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;


    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<ApplicationUser> students = new ArrayList<>();


    public Course(String name) {
        this.name = name;
    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public void addStudent(ApplicationUser student) {
        this.students.add(student);
    }

    public void removeStudent(ApplicationUser student) {
        this.students.remove(student);
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + "]";
    }

}