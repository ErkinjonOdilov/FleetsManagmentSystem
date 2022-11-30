package com.kindsonthegenius.fleetmvsv2.hr.services;

import com.kindsonthegenius.fleetmvsv2.hr.models.EmployeeStatus;
import com.kindsonthegenius.fleetmvsv2.hr.repository.EmployeeStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeStatusService {

    @Autowired
    private EmployeeStatusRepository employeeStatusRepository;


    public List<EmployeeStatus> findAll(){
        return employeeStatusRepository.findAll();
    }


    public EmployeeStatus findById(int id) {
        return employeeStatusRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        employeeStatusRepository.deleteById(id);
    }


    public void save( EmployeeStatus employeeStatus) {
        employeeStatusRepository.save(employeeStatus);
    }
}