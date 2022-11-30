package com.kindsonthegenius.fleetmvsv2.fleet.repository;


import com.kindsonthegenius.fleetmvsv2.fleet.models.VehicleHire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {

}