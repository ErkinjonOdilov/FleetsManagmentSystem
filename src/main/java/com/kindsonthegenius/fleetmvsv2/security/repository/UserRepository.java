package com.kindsonthegenius.fleetmvsv2.security.repository;


import com.kindsonthegenius.fleetmvsv2.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}