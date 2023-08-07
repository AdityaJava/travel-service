package com.krishna.travels.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_package_id")
    Long travelPackageId;

    @Column(name = "package_name")
    String packageName;

    @Column(name = "start_date")
    LocalDate startDate;

    @Column(name = "end_date")
    LocalDate endDate;

    @Column(name = "city_id")
    Long cityId;

    @OneToMany(mappedBy = "cityId")
    List<City> cities;

}
