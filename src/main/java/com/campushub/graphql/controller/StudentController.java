package com.campushub.graphql.controller;

import com.campushub.graphql.model.Student;
import com.campushub.graphql.model.Subject;
import com.campushub.graphql.service.StudentService;
import com.campushub.graphql.service.SubjectService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final SubjectService subjectService;

    public StudentController(StudentService studentService,
                             SubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    // ─────────────────────────────────────────────────────────────────────
    // CQRS — READ MODEL (Queries)
    // These methods only retrieve data. They never change system state.
    // ─────────────────────────────────────────────────────────────────────

    // TODO 1: Map this method to the GraphQL Query "getStudentById".
    // Use the @QueryMapping annotation.
    // Use @Argument to receive the "id" parameter as a Long.
    // Delegate to studentService.findById(id) and return the result.
    @QueryMapping
    public Student getStudentById(@Argument Long id) {
        // TODO: Implement this method
        return null;
    }

    // TODO 2: Map this method to the GraphQL Query "getAllStudents".
    // Use the @QueryMapping annotation.
    // Delegate to studentService.findAll() and return the result.
    @QueryMapping
    public List<Student> getAllStudents() {
        // TODO: Implement this method
        return null;
    }

    // ─────────────────────────────────────────────────────────────────────
    // LAZY GRAPH RESOLUTION (Nested Relationship)
    // Resolves the "subjects" field on a Student only when the client
    // explicitly requests it — a key GraphQL + CQRS efficiency pattern.
    // ─────────────────────────────────────────────────────────────────────

    // TODO 3: Resolve the nested "subjects" field on a Student object.
    // Use the @SchemaMapping annotation — Spring infers type=Student, field=subjects
    // from the method name and parameter type automatically.
    // Receive the parent Student object as a parameter.
    // Delegate to subjectService.findByStudentId(student.getId()).
    @SchemaMapping
    public List<Subject> subjects(Student student) {
        // TODO: Implement this method
        return null;
    }

    // ─────────────────────────────────────────────────────────────────────
    // CQRS — WRITE MODEL (Mutations)
    // This method changes system state. It is clearly separated from the
    // read model above — that separation IS the CQRS pattern.
    // ─────────────────────────────────────────────────────────────────────

    // TODO 4: Map this method to the GraphQL Mutation "createStudent".
    // Use the @MutationMapping annotation.
    // Use @Argument for both "name" and "email" String parameters.
    // Delegate to studentService.createNewStudent(name, email) and return the result.
    @MutationMapping
    public Student createStudent(@Argument String name,
                                 @Argument String email) {
        // TODO: Implement this method
        return null;
    }

    // ─────────────────────────────────────────────────────────────────────
    // ALREADY IMPLEMENTED — no changes needed below this line
    // ─────────────────────────────────────────────────────────────────────

    @MutationMapping
    public Subject addSubjectToStudent(@Argument Long studentId,
                                       @Argument String subjectName) {
        return subjectService.addSubjectToStudent(studentId, subjectName);
    }
}
