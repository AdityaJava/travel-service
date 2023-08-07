package com.krishna.travels.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
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

}
