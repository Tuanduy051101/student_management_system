package com.company.projects.course.warehouse.repository;

import com.company.projects.course.coursemanagementsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
