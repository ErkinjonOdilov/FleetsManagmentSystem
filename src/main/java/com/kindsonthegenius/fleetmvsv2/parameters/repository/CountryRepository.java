package com.kindsonthegenius.fleetmvsv2.parameters.repository;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "SELECT c from Country c where "+"c.description like %?1% or c.capital like %?1% or c.continent like %?1%")
    List<Country> getByKeyword1(String keyword);

    @Query(value = "SELECT c from Country c where "+"concat(c.description, c.capital, c.code,c.continent, c.nationality) like %?1%")
    List<Country> findByKeyword(String keyword);
}
