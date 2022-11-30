package com.kindsonthegenius.fleetmvsv2.accounts.services;

import com.kindsonthegenius.fleetmvsv2.accounts.models.TransactionStatus;
import com.kindsonthegenius.fleetmvsv2.accounts.repository.TransactionStatusRepository;
import com.kindsonthegenius.fleetmvsv2.fleet.models.VehicleHire;
import com.kindsonthegenius.fleetmvsv2.fleet.repository.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionStatusService {
    @Autowired
    private TransactionStatusRepository transactionStatusRepository;
    public List<TransactionStatus> findAll(){
        return transactionStatusRepository.findAll();
    }


    public TransactionStatus findById(int id) {
        return transactionStatusRepository.findById(id).orElse(null);
    }


    public void delete(int id) {
        transactionStatusRepository.deleteById(id);
    }


    public void save(TransactionStatus transactionStatus) {
        transactionStatusRepository.save(transactionStatus);
    }


}
