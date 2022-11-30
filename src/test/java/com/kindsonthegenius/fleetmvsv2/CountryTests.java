package com.kindsonthegenius.fleetmvsv2;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Country;
import com.kindsonthegenius.fleetmvsv2.parameters.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryTests {


    @Autowired
    private CountryRepository repository;


    //FindByID
    @Test
    public void testGetById(){
        Country country=repository.findById(10).orElse(null);
        assertNotNull(country);
    }

    @Test
    public void testGetByIdEmpty(){
        Country country=repository.findById(100).orElse(null);
        assertNotNull(country);
    }

    @Test
    public void testGetByIdNull (){
        Country country=repository.findById(100).orElse(null);
        assertNull(country);
    }


    //FindByIdEmp
}
