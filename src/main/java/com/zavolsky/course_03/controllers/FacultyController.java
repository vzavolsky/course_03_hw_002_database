package com.zavolsky.course_03.controllers;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.services.FacultyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/faculty")
@Tag(name = "Faculty Controller", description = "UI for faculties.")
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
    public ResponseEntity<Optional<Faculty>> get(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.get(id));
    }

    @PostMapping
    public ResponseEntity<Faculty> add(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.add(faculty));
    }

    @PutMapping
    public ResponseEntity<Optional<Faculty>> update(@RequestBody Long id, @RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(id, faculty));
    }

    @DeleteMapping
    public ResponseEntity<Optional<Faculty>> delete(@RequestBody Long id) {
        facultyService.remove(id);
        return ResponseEntity.ok().build();
    }

}
