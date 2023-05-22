package com.zavolsky.course_03.repositories;

import com.zavolsky.course_03.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT id, name, age from students where age = :age")
    List<Student> findAllByAge(@Param("age") final Integer age);

}
