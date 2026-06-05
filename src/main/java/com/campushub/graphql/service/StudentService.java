package com.campushub.graphql.service;

import com.campushub.graphql.model.Student;
import com.campushub.graphql.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public Student createNewStudent(String name, String email) {
        Student student = new Student(name, email);
        return studentRepository.save(student);
    }
}
