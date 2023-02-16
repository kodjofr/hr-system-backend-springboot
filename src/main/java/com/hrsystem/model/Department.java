package com.hrsystem.model;


import java.util.List;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "department")
public class Department {

    public enum Departments {
        HR,
        IT,
        CUSTOMER_SERVICE,
        ACCOUNTING,
        MARKETING,
        SALES

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Departments name;

    @ManyToOne
    private Employee manager;
    private int headcount;
    @OneToMany
    private List<Project> projets;


}

