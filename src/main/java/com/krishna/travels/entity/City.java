package com.krishna.travels.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    Long cityId;

    @Column(name = "city_name")
    String cityName;

    @Column(name = "state_name")
    String stateName;

    @Column(name = "country_name")
    String countryName;

}
