package com.krishna.travels.city;

import com.krishna.travels.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping
    public List<City> getCities() {
        return cityService.getCities();
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.getCity(id);
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PostMapping("/list")
    public List<City> createCities(@RequestBody List<City> cities) {
        return cityService.createCities(cities);
    }


    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }

}
