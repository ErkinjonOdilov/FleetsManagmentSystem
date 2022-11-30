package com.kindsonthegenius.fleetmvsv2.accounts.services;

import com.kindsonthegenius.fleetmvsv2.accounts.models.Invoice;
import com.kindsonthegenius.fleetmvsv2.accounts.models.Transaction;
import com.kindsonthegenius.fleetmvsv2.accounts.repository.InvoiceRepository;
import com.kindsonthegenius.fleetmvsv2.accounts.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> findAll(){
        return invoiceRepository.findAll();
    }

    //Get VehicleHire By Id
    public Invoice findById(int id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    //Delete VehicleHire
    public void delete(int id) {
        invoiceRepository.deleteById(id);
    }

    //Update VehicleHire
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

}
