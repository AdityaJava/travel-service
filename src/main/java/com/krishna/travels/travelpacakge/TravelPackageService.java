package com.krishna.travels.travelpacakge;

import com.krishna.travels.entity.TravelPackage;
import com.krishna.travels.repository.TravelPackageRepository;
import com.krishna.travels.specifications.Filter;
import com.krishna.travels.specifications.TravelPackageSpecificationCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TravelPackageService {

    @Autowired
    TravelPackageSpecificationCreator travelPackageSpecificationCreator;

    @Autowired
    TravelPackageRepository travelPackageRepository;

    public Page<TravelPackage> getTravelPackages(Filter filter, Pageable pageable) {
        Specification<TravelPackage> travelPackageSpecification = travelPackageSpecificationCreator.createSpecification(filter);
        return travelPackageRepository.findAll(travelPackageSpecification, pageable);
    }

    public TravelPackage getTravelPackage(Long id) {
        return travelPackageRepository.findById(id).orElse(null);
    }

    public TravelPackage createTravelPackage(TravelPackage travelPackage) {
        return travelPackageRepository.save(travelPackage);
    }

    public TravelPackage updateTravelPackage(Long id, TravelPackage travelPackage) {
        if (travelPackage.getTravelPackageId() == null) {
            throw new RuntimeException("Id cannot be null");
        }
        if (id == travelPackage.getTravelPackageId()) {
            return travelPackageRepository.save(travelPackage);
        }
        throw new RuntimeException("Id's are not same");
    }

    public List<TravelPackage> createTravelPackages(List<TravelPackage> travelPackages) {
        return travelPackageRepository.saveAll(travelPackages);
    }
}
