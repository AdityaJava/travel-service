package com.krishna.travels.packagevent;

import com.krishna.travels.entity.PackageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/packageEvents")
public class PackageEventController {

    @Autowired
    PackageEventService packageEventService;

    @GetMapping
    public Page<PackageEvent> getAllTravelPackages(Pageable pageable) {
        return packageEventService.getAllTravelPackages(pageable);
    }

    @PostMapping
    public PackageEvent createEventOnTravelPackage(@RequestBody PackageEvent packageEvent) {
        return packageEventService.createEventOnTravelPackage(packageEvent);
    }

    @PostMapping("/list")
    public List<PackageEvent> createEventOnTravelPackages(@RequestBody List<PackageEvent> packageEvents) {
        return packageEventService.createEventOnTravelPackages(packageEvents);
    }

    @DeleteMapping("/{id}")
    public void deletePackageEvent(@PathVariable("id") Long id) {
        packageEventService.deletePackageEvent(id);
    }

}
