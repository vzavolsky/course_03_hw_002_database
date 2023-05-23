package com.zavolsky.course_03.controllers;

import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.get(id));
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(student));
    }

    @PutMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(student));
    }

    @DeleteMapping
    public ResponseEntity<Student> delete(@RequestBody Student student) {
        studentService.remove(student);
        return ResponseEntity.ok().build();
    }

}
