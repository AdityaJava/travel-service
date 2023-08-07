package com.krishna.travels.city;

import com.krishna.travels.entity.City;
import com.krishna.travels.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City getCity(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public Page<City> getCities(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public List<City> createCities(List<City> cities) {
        return cityRepository.saveAll(cities);
    }
}
