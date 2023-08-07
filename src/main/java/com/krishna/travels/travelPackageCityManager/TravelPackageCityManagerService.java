package com.krishna.travels.travelPackageCityManager;

import com.krishna.travels.entity.TravelPackageCityManager;
import com.krishna.travels.repository.TravelPackageCityManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPackageCityManagerService {

    @Autowired
    private TravelPackageCityManagerRepository travelPackageCityManagerRepository;

    public TravelPackageCityManager createTravelPackageCityManager(TravelPackageCityManager travelPackageCityManager) {
        return travelPackageCityManagerRepository.save(travelPackageCityManager);
    }

    public TravelPackageCityManager getTravelPackageCityManager(Long id) {
        return travelPackageCityManagerRepository.findById(id).orElse(null);
    }

    public Page<TravelPackageCityManager> getTravelPackageCityManagers(Pageable pageable) {
        return travelPackageCityManagerRepository.findAll(pageable);
    }

    public void deleteTravelPackageCityManager(Long id) {
        travelPackageCityManagerRepository.deleteById(id);
    }

    public List<TravelPackageCityManager> createTravelPackageCityManagers(List<TravelPackageCityManager> travelPackageCityManagers) {
        return travelPackageCityManagerRepository.saveAll(travelPackageCityManagers);
    }
}
