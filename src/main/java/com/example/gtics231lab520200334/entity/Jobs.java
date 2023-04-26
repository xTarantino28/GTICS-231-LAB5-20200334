package com.example.gtics231lab520200334.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false)
    private String job_id;

    @Column(name = "job_title")
    private String job_title;

    private Integer min_salary;

    private Integer max_salary;


}
