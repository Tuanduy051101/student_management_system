package com.company.projects.course.warehouse.model;

import javax.persistence.*;

@Entity
public class ProductAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attributeName;
    private String attributeValue;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
