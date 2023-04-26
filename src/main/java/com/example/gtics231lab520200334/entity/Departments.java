package com.example.gtics231lab520200334.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer department_id;

    @Column(name = "department_name")
    private String department_name;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees employees;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locations;


}
