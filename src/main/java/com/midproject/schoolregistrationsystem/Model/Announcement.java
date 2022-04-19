package com.midproject.schoolregistrationsystem.Model;


import com.midproject.schoolregistrationsystem.Enum.Department;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Announcement {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreationTimestamp
    private Timestamp createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "department")
    private Department department;

    @Column(columnDefinition="TEXT")
    private String description;

    public Announcement(Timestamp createdAt, Department department, String description) {
        this.createdAt = createdAt;
        this.department = department;
        this.description = description;
    }
}
