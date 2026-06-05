package com.campushub.graphql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int credits = 3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Subject() {}

    public Subject(String name, Student student) {
        this.name    = name;
        this.student = student;
    }

    public Long getId()                { return id; }
    public void setId(Long id)         { this.id = id; }

    public String getName()            { return name; }
    public void setName(String name)   { this.name = name; }

    public int getCredits()            { return credits; }
    public void setCredits(int credits){ this.credits = credits; }

    public Student getStudent()               { return student; }
    public void setStudent(Student student)   { this.student = student; }
}
