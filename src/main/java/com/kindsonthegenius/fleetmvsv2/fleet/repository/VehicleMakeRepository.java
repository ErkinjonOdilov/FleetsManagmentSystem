package com.kindsonthegenius.fleetmvsv2.fleet.repository;


import com.kindsonthegenius.fleetmvsv2.fleet.models.VehicleMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Integer> {

}