package com.company.projects.course.warehouse.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String manager;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private Set<Product> products;

}