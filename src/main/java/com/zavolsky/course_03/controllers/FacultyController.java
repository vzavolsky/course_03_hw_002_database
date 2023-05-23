package com.zavolsky.course_03.controllers;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.services.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {

    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> findALl() {
        return ResponseEntity.ok(facultyService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Faculty> get(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.get(id));
    }

    @PostMapping
    public ResponseEntity<Faculty> add(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(faculty));
    }

    @PutMapping
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(faculty));
    }

    @DeleteMapping
    public ResponseEntity<Faculty> delete(@RequestBody Faculty faculty) {
        facultyService.remove(faculty);
        return ResponseEntity.ok().build();
    }

}
