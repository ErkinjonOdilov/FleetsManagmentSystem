package com.kindsonthegenius.fleetmvsv2.parameters.repository;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Client;
import com.kindsonthegenius.fleetmvsv2.parameters.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
