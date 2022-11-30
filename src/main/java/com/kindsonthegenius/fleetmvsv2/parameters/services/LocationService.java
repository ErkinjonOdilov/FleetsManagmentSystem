package com.kindsonthegenius.fleetmvsv2.parameters.services;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Location;
import com.kindsonthegenius.fleetmvsv2.parameters.models.State;
import com.kindsonthegenius.fleetmvsv2.parameters.repository.LocationRepository;
import com.kindsonthegenius.fleetmvsv2.parameters.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAll(){
        return locationRepository.findAll();
    }

    public void save(Location location){
        locationRepository.save(location);
    }

    public void delete(Integer id){
        locationRepository.deleteById(id);
    }

    public Location getById(Integer id) {
        return locationRepository.findById(id).orElse(null);
    }
}
