package com.krishna.travels.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PackageEvent {

    @Id
    @Column(name = "package_event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long packageEventId;

    @Column(name = "travel_package_id")
    Long travelPackageId;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "start_date")
    LocalDate startDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "end_date")
    LocalDate endDate;

}
