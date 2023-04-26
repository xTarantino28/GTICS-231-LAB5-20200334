package com.example.gtics231lab520200334.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "countries")
public class Countries {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private String country_id;

    @Column(name = "country_name")
    private String country_name;


    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regions regions;
}
