package com.krishna.travels.travelPackageCityManager;

import com.krishna.travels.entity.TravelPackageCityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/travelPackageCityManagers")
public class TravelPackageCityManagerController {

    @Autowired
    TravelPackageCityManagerService travelPackageCityManagerService;

    @GetMapping
    public Page<TravelPackageCityManager> getTravelPackageCityManagers(Pageable pageable) {
        return travelPackageCityManagerService.getTravelPackageCityManagers(pageable);
    }

    @GetMapping("/{id}")
    public TravelPackageCityManager getTravelPackageCityManager(@PathVariable Long id) {
        return travelPackageCityManagerService.getTravelPackageCityManager(id);
    }

    @PostMapping
    public TravelPackageCityManager createTravelPackageCityManager(@RequestBody TravelPackageCityManager travelPackageCityManager) {
        return travelPackageCityManagerService.createTravelPackageCityManager(travelPackageCityManager);
    }

    @PostMapping("/list")
    public List<TravelPackageCityManager> createTravelPackageCityManagers(@RequestBody List<TravelPackageCityManager> travelPackageCityManagers) {
        return travelPackageCityManagerService.createTravelPackageCityManagers(travelPackageCityManagers);
    }


    @DeleteMapping("/{id}")
    public void deleteTravelPackageCityManager(@PathVariable Long id) {
        travelPackageCityManagerService.deleteTravelPackageCityManager(id);
    }

}
