package com.example.gtics231lab520200334.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer iduser;

    @Column(name = "first_name")
    private String first_name;

    private String last_name;

    private String email;

    private String password;

    private String phone_number;

    private Date hire_date;

    private Double salary;

    private Double commission_pct;

    private Integer enabled;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees employees;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;






}
