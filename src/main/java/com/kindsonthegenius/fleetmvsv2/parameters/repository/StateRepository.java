package com.kindsonthegenius.fleetmvsv2.parameters.repository;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Country;
import com.kindsonthegenius.fleetmvsv2.parameters.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
