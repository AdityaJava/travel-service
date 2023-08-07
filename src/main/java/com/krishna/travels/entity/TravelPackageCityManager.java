package com.krishna.travels.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TravelPackageCityManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_package_city_manager_id")
    Long travelPackageCityManagerId;

    @Column(name = "travel_package_id")
    Long travelPackageId;

    @Column(name = "city_id")
    Long cityId;

    @Column(name = "start_date")
    LocalDate startDate;

    @Column(name = "end_date")
    LocalDate endDate;

}
