package com.campushub.graphql.service;

import com.campushub.graphql.model.Student;
import com.campushub.graphql.model.Subject;
import com.campushub.graphql.repository.StudentRepository;
import com.campushub.graphql.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public SubjectService(SubjectRepository subjectRepository,
                          StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public List<Subject> findByStudentId(Long studentId) {
        return subjectRepository.findByStudentId(studentId);
    }

    public Subject addSubjectToStudent(Long studentId, String subjectName) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        Subject subject = new Subject(subjectName, student);
        return subjectRepository.save(subject);
    }
}
