package com.krishna.travels.repository;

import com.krishna.travels.entity.TravelPackageCityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TravelPackageCityManagerRepository extends JpaRepository<TravelPackageCityManager, Long>, JpaSpecificationExecutor<TravelPackageCityManager> {
}
