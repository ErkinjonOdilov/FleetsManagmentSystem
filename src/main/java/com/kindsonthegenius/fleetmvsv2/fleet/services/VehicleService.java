package com.kindsonthegenius.fleetmvsv2.fleet.services;

import com.kindsonthegenius.fleetmvsv2.fleet.models.Vehicle;
import com.kindsonthegenius.fleetmvsv2.fleet.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.InputStream;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	//Get All Vehicles
	public List<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}	
	
	//Get Vehicle By Id
	public Vehicle findById(int id) {
		return vehicleRepository.findById(id).orElse(null);
	}	
	
	//Delete Vehicle
	public void delete(int id) {
		vehicleRepository.deleteById(id);
	}
	
	//Update Vehicle
	public void save(Vehicle vehicle, MultipartFile file) {
		vehicleRepository.save(vehicle);
		try {
			String realName = file.getOriginalFilename();
			Files.copy(file.getInputStream(), Paths.get("/img/vehicle/" + vehicle.getId() + Objects.requireNonNull(realName).substring(realName.lastIndexOf("."))), StandardCopyOption.REPLACE_EXISTING);
		}catch (Exception e){
			System.out.print("Hello");
		}
	}

}