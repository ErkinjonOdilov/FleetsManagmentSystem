package com.kindsonthegenius.fleetmvsv2.parameters.services;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Client;
import com.kindsonthegenius.fleetmvsv2.parameters.models.Supplier;
import com.kindsonthegenius.fleetmvsv2.parameters.repository.ClientRepository;
import com.kindsonthegenius.fleetmvsv2.parameters.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAll(){
        return supplierRepository.findAll();
    }

    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void delete(Integer id){
        supplierRepository.deleteById(id);
    }

    public Supplier getById(Integer id) {
        return supplierRepository.findById(id).orElse(null);
    }
}
