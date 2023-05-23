package com.zavolsky.course_03.services;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty update(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty get(Long id) {
        return facultyRepository.findById(id).get();
    }

    public void remove(Faculty faculty) {
        facultyRepository.delete(faculty);
    }

    public Collection<Faculty> findAll() {
        return facultyRepository.findAll();
    }

}
