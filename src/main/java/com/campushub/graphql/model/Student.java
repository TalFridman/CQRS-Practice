package com.campushub.graphql.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subject> subjects = new ArrayList<>();

    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId()                    { return id; }
    public void setId(Long id)             { this.id = id; }

    public String getName()                { return name; }
    public void setName(String name)       { this.name = name; }

    public String getEmail()               { return email; }
    public void setEmail(String email)     { this.email = email; }

    public List<Subject> getSubjects()             { return subjects; }
    public void setSubjects(List<Subject> subjects) { this.subjects = subjects; }
}
