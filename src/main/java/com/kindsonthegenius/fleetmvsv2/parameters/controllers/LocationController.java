package com.kindsonthegenius.fleetmvsv2.parameters.controllers;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Location;

import com.kindsonthegenius.fleetmvsv2.parameters.services.CountryService;
import com.kindsonthegenius.fleetmvsv2.parameters.services.LocationService;
import com.kindsonthegenius.fleetmvsv2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocationController {

    @Autowired	private LocationService locationService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;

    public Model addModelAttributes(Model model){
        model.addAttribute("locations", locationService.getAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.getAll());
        return model;
    }

    @GetMapping("/parameters/locations")
    public String findAll(Model model){
        addModelAttributes(model);
        return "/parameters/locations";
    }

    @GetMapping("/parameters/locationAdd")
    public String addLocation(Model model){
        model.addAttribute("countries", countryService.findAll());
        return "parameters/locationAdd";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/parameters/location/{op}/{id}")
    public String editLocation(@PathVariable Integer id, @PathVariable String op, Model model){
        Location location = locationService.getById(id);
        model.addAttribute("location", location);
        addModelAttributes(model);
        return "/parameters/location"+ op; //returns locationEdit or locationDetails
    }

    @PostMapping("/parameters/locations")
    public String save(Location location) {
        locationService.save(location);
        return "redirect:/parameters/locations";
    }

    @RequestMapping(value="/parameters/location/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@PathVariable Integer id) {
        locationService.delete(id);
        return "redirect:/parameters/locations";
    }

}