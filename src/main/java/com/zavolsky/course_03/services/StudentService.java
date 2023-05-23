package com.zavolsky.course_03.services;

import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public Student get(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public void remove(Student student) {
        studentRepository.delete(student);
    }

    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

}
