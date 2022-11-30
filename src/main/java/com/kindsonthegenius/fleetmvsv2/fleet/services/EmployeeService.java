package com.kindsonthegenius.fleetmvsv2.fleet.services;

import com.kindsonthegenius.fleetmvsv2.fleet.models.VehicleHire;
import com.kindsonthegenius.fleetmvsv2.fleet.models.VehicleMaintenance;
import com.kindsonthegenius.fleetmvsv2.hr.models.Employee;
import com.kindsonthegenius.fleetmvsv2.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }


    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }



}
