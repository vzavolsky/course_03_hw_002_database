package com.zavolsky.course_03.services;

import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public Optional<Student> get(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> update(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
    }

    public Optional<Student> remove(Long id) {
        if (studentRepository.existsById(id)) {
            Student student = studentRepository.findById(id).get();
            studentRepository.deleteById(id);
            return Optional.of(student);
        }
        return Optional.empty();
    }

    public Collection<Student> findAll() {
        return Collections.unmodifiableCollection(studentRepository.findAll());
    }

}
