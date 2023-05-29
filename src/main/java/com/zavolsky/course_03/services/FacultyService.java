package com.zavolsky.course_03.services;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(Faculty faculty) {
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> get(Long id) {
        return facultyRepository.findById(id);
    }

    public Optional<Faculty> update(Long id, Faculty faculty) {
        if (facultyRepository.existsById(id)) {
            faculty.setId(id);
            return Optional.of(facultyRepository.save(faculty));
        }
        return Optional.empty();
    }

    public Optional<Faculty> remove(Long id) {
        if (facultyRepository.existsById(id)) {
            Faculty faculty = facultyRepository.findById(id).get();
            facultyRepository.deleteById(id);
            return Optional.of(faculty);
        }
        return Optional.empty();
    }

    public Collection<Faculty> findAll() {
        return Collections.unmodifiableCollection(facultyRepository.findAll());
    }

}
