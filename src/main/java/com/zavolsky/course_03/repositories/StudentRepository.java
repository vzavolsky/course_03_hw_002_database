package com.zavolsky.course_03.repositories;

import com.zavolsky.course_03.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
