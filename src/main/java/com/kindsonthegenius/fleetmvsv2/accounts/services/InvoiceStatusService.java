package com.kindsonthegenius.fleetmvsv2.accounts.services;

import com.kindsonthegenius.fleetmvsv2.accounts.models.Invoice;
import com.kindsonthegenius.fleetmvsv2.accounts.models.InvoiceStatus;
import com.kindsonthegenius.fleetmvsv2.accounts.repository.InvoiceRepository;
import com.kindsonthegenius.fleetmvsv2.accounts.repository.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> findAll(){
        return invoiceStatusRepository.findAll();
    }

    //Get VehicleHire By Id
    public InvoiceStatus findById(int id) {
        return invoiceStatusRepository.findById(id).orElse(null);
    }

    //Delete VehicleHire
    public void delete(int id) {
        invoiceStatusRepository.deleteById(id);
    }

    //Update VehicleHire
    public void save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

}
