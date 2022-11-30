package com.kindsonthegenius.fleetmvsv2.fleet.controllers;

import com.kindsonthegenius.fleetmvsv2.fleet.models.Vehicle;
import com.kindsonthegenius.fleetmvsv2.fleet.services.*;
import com.kindsonthegenius.fleetmvsv2.parameters.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleTypeService vehicleTypeService;
	@Autowired
	private VehicleMakeService vehicleMakeService;
	@Autowired
	private VehicleModelService vehicleModelService;
	@Autowired
	private LocationService locationService;

	@Autowired
	private VehicleStatusService vehicleStatusService;

	public Model addModelAttributes(Model model){
		model.addAttribute("vehicles", vehicleService.findAll());
		model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
		model.addAttribute("vehicleModels", vehicleModelService.findAll());
		model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
		model.addAttribute("locations", locationService.getAll());
		model.addAttribute("vehicleStatuses", vehicleStatusService.findAll());
		return model;
	}


	@GetMapping("/fleet/vehicles")
	public String findAll(Model model){		
		addModelAttributes(model);
		return "/fleet/vehicles";
	}

	@GetMapping("/fleet/vehicleAdd")
	public String addVehicle(Model model){
		addModelAttributes(model);
		return "fleet/vehicleAdd";
	}


	@GetMapping("/fleet/vehicle/{op}/{id}")
	public String editVehicle(@PathVariable Integer id, @PathVariable String op, Model model){
		Vehicle vehicle = vehicleService.findById(id);
		model.addAttribute("vehicle", vehicle);
		addModelAttributes(model);
		return "/fleet/vehicle"+ op; //returns vehicleEdit or vehicleDetails
	}


	@PostMapping("/fleet/vehicles")
	public String addNew(Vehicle vehicle, MultipartFile file) {
		vehicleService.save(vehicle, file);
		return "redirect:/fleet/vehicles";
	}	

	@RequestMapping(value="/fleet/vehicle/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		vehicleService.delete(id);
		return "redirect:/fleet/vehicles";
	}
}