package com.kindsonthegenius.fleetmvsv2.fleet.restapis;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Country;
import com.kindsonthegenius.fleetmvsv2.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/api/parameters/countries")
    public List<Country>  getAll(Model model){
        List<Country> countries=countryService.findAll();
        return countries;
    }
}
