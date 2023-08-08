package com.krishna.travels.repository;

import com.krishna.travels.entity.PackageEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PackageEventRepository extends JpaRepository<PackageEvent, Long> {

    public PackageEvent findByStartDateEqualsAndEndDateEqualsAndTravelPackageIdEquals(LocalDate startDate, LocalDate endDate, Long travelPackageId);
}
