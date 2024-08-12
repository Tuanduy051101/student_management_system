package com.company.projects.student.repository;

import com.company.projects.course.coursemanagementsystem.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
