package com.kindsonthegenius.fleetmvsv2.fleet.repository;

import com.kindsonthegenius.fleetmvsv2.fleet.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleModelRepository extends JpaRepository<VehicleModel, Integer> {

}