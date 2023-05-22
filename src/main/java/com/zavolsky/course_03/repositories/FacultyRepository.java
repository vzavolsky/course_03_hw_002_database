package com.zavolsky.course_03.repositories;

import com.zavolsky.course_03.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
