package com.kindsonthegenius.fleetmvsv2.hr.services;

import com.kindsonthegenius.fleetmvsv2.hr.models.EmployeeType;
import com.kindsonthegenius.fleetmvsv2.hr.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public List<EmployeeType> findAll(){
        return employeeTypeRepository.findAll();
    }

    public EmployeeType findById(int id) {
        return employeeTypeRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        employeeTypeRepository.deleteById(id);
    }

    public void save( EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

}