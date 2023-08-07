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

    @OneToMany(mappedBy = "travelPackageId")
    List<TravelPackageCityManager> travelPackageCityManagers;

}
