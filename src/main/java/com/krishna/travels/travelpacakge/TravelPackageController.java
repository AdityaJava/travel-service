package com.krishna.travels.travelpacakge;

import com.krishna.travels.entity.TravelPackage;
import com.krishna.travels.specifications.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/travelpackages")
public class TravelPackageController {

    @Autowired
    private TravelPackageService travelPackageService;

    @GetMapping
    public Page<TravelPackage> getTravelPackages(Filter filter, Pageable pageable) {
        return travelPackageService.getTravelPackages(filter, pageable);
    }

    @GetMapping("/{id}")
    public TravelPackage getTravelPackage(@PathVariable("id") Long id) {
        return travelPackageService.getTravelPackage(id);
    }

    @PostMapping
    public TravelPackage createTravelPackage(@RequestBody TravelPackage travelPackage){
        return travelPackageService.createTravelPackage(travelPackage);
    }

    @PostMapping("/list")
    public List<TravelPackage> createTravelPackages(@RequestBody List<TravelPackage> travelPackages){
        return travelPackageService.createTravelPackages(travelPackages);
    }

    @PutMapping("/{id}")
    public TravelPackage updateTravelPackage(Long id,@RequestBody TravelPackage travelPackage){
        return travelPackageService.updateTravelPackage(id,travelPackage);
    }

//    public TravelPackage createEventOnTravelPackage{
//        return null;
//    }

}
