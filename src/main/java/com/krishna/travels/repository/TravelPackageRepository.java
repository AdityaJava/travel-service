package com.krishna.travels.repository;

import com.krishna.travels.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long>,JpaSpecificationExecutor<TravelPackage> {

}
