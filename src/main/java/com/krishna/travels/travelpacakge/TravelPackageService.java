package com.krishna.travels.travelpacakge;

import com.krishna.travels.entity.PackageEvent;
import com.krishna.travels.entity.TravelPackage;
import com.krishna.travels.repository.PackageEventRepository;
import com.krishna.travels.repository.TravelPackageRepository;
import com.krishna.travels.specifications.Filter;
import com.krishna.travels.specifications.SpecificationCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class TravelPackageService {

    @Autowired
    SpecificationCreator specificationCreator;

    @Autowired
    TravelPackageRepository travelPackageRepository;

    @Autowired
    PackageEventRepository packageEventRepository;

    public Page<TravelPackage> getTravelPackages(Filter filter, Pageable pageable) {
        Specification<TravelPackage> travelPackageSpecification = specificationCreator.<TravelPackage>createSpecification(filter);
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

    public PackageEvent createEventOnTravelPackage(PackageEvent packageEvent) {
        if (packageEvent.getTravelPackageId() == null) {
            throw new RuntimeException("TravelPackageId is needed");
        }
        if (packageEvent.getStartDate() == null || packageEvent.getEndDate() == null) {
            throw new RuntimeException("StartDate and EndDate cannot be null");
        }
        TravelPackage travelPackage = travelPackageRepository.findById(packageEvent.getTravelPackageId()).orElse(null);
        if (travelPackage == null) {
            throw new RuntimeException("No such TravelPackage with id=" + packageEvent.getTravelPackageId());
        }

        PackageEvent savedPackageEvent = packageEventRepository.findByStartDateEqualsAndEndDateEqualsAndTravelPackageIdEquals(packageEvent.getStartDate(), packageEvent.getEndDate(), packageEvent.getTravelPackageId());
        if (savedPackageEvent != null) {
            throw new RuntimeException("PackageEvent is already registered on this date " + savedPackageEvent);
        }
        return packageEventRepository.save(packageEvent);
    }

    public List<PackageEvent> createEventOnTravelPackages(List<PackageEvent> packageEvents) {
        List<PackageEvent> createdPackageEvents = new ArrayList<>();
        for (PackageEvent packageEvent : packageEvents) {
            createdPackageEvents.add(createEventOnTravelPackage(packageEvent));
        }
        return createdPackageEvents;
    }

    public Page<PackageEvent> getAllTravelPackages(Pageable pageable) {
        return packageEventRepository.findAll(pageable);
    }
}
