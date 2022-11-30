package com.kindsonthegenius.fleetmvsv2.parameters.repository;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
