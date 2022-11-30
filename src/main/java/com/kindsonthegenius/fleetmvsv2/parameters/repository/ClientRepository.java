package com.kindsonthegenius.fleetmvsv2.parameters.repository;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Client;
import com.kindsonthegenius.fleetmvsv2.parameters.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
