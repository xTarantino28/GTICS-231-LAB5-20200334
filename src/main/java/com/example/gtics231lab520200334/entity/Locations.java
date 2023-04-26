package com.example.gtics231lab520200334.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "locations")
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Integer location_id;

    @Column(name = "street_address")
    private String street_address;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "city")
    private String city;

    @Column(name = "state_province")
    private String state_province;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries countries;

}
