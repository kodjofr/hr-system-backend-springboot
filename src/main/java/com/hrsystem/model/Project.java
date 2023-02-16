
package com.hrsystem.model;


import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String codeName;
    private String description;
    private int budget;

    @OneToMany
    private List<Employee> team;
    private Date startDate;
    private Date deadline;

    @OneToMany
    private List<Task> tasks;

}

