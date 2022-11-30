package com.kindsonthegenius.fleetmvsv2.hr.repository;

import com.kindsonthegenius.fleetmvsv2.hr.models.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatus, Integer> {
}
