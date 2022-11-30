package com.kindsonthegenius.fleetmvsv2.accounts.services;

import com.kindsonthegenius.fleetmvsv2.accounts.models.Transaction;
import com.kindsonthegenius.fleetmvsv2.accounts.models.TransactionType;
import com.kindsonthegenius.fleetmvsv2.accounts.repository.TransactionRepository;
import com.kindsonthegenius.fleetmvsv2.accounts.repository.TransactionTypeRepository;
import com.kindsonthegenius.fleetmvsv2.fleet.models.VehicleHire;
import com.kindsonthegenius.fleetmvsv2.fleet.repository.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeService {
    @Autowired
    private TransactionTypeRepository transactionTypeRepositoryRepository;

    public List<TransactionType> findAll(){
        return transactionTypeRepositoryRepository.findAll();
    }


    public TransactionType findById(int id) {
        return transactionTypeRepositoryRepository.findById(id).orElse(null);
    }


    public void delete(int id) {
        transactionTypeRepositoryRepository.deleteById(id);
    }


    public void save(TransactionType transaction) {
        transactionTypeRepositoryRepository.save(transaction);
    }


}
