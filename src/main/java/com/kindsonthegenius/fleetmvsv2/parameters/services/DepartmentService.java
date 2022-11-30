package com.kindsonthegenius.fleetmvsv2.parameters.services;
import com.kindsonthegenius.fleetmvsv2.parameters.models.Department;
import com.kindsonthegenius.fleetmvsv2.parameters.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

        public List<Department> findAll(){
        return departmentRepository.findAll();
    }


    public Department findById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

        public void delete(int id) {
        departmentRepository.deleteById(id);
    }


    public void save( Department department) {
        departmentRepository.save(department);
    }

}