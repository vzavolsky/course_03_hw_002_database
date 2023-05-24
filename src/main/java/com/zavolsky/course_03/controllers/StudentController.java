package com.zavolsky.course_03.controllers;

import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.services.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
@Tag(name = "Student Controller", description = "UI for students.")
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
    public ResponseEntity<Optional<Student>> get(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.get(id));
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.add(student));
    }

    @PutMapping
    public ResponseEntity<Optional<Student>> save(@RequestBody Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(id, student));
    }

    @DeleteMapping
    public ResponseEntity<Optional<Student>> delete(@RequestBody Long id) {
        return ResponseEntity.ok(studentService.remove(id));
    }

}
