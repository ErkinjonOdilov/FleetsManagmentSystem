package com.kindsonthegenius.fleetmvsv2.hr.repository;

import com.kindsonthegenius.fleetmvsv2.hr.models.JobTitle;
import com.kindsonthegenius.fleetmvsv2.hr.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
