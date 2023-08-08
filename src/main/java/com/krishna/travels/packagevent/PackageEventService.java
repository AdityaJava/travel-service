package com.krishna.travels.packagevent;

import com.krishna.travels.entity.PackageEvent;
import com.krishna.travels.entity.TravelPackage;
import com.krishna.travels.repository.PackageEventRepository;
import com.krishna.travels.repository.TravelPackageRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class PackageEventService {

    @Autowired
    PackageEventRepository packageEventRepository;

    @Autowired
    TravelPackageRepository travelPackageRepository;

    public PackageEvent createEventOnTravelPackage(PackageEvent packageEvent) {
        if (packageEvent.getTravelPackageId() == null) {
            throw new RuntimeException("TravelPackageId is needed");
        }
        if (packageEvent.getStartDate() == null || packageEvent.getEndDate() == null) {
            throw new RuntimeException("StartDate and EndDate cannot be null");
        }
        if(packageEvent.getStartDate().isAfter(packageEvent.getEndDate())){
            throw new RuntimeException("StartDate should be before EndDate");
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

    public void deletePackageEvent(Long id) {
        packageEventRepository.deleteById(id);
    }
}
