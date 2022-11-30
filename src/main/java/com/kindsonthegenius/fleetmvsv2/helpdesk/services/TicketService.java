package com.kindsonthegenius.fleetmvsv2.helpdesk.services;

import com.kindsonthegenius.fleetmvsv2.accounts.models.Transaction;
import com.kindsonthegenius.fleetmvsv2.accounts.repository.TransactionRepository;
import com.kindsonthegenius.fleetmvsv2.helpdesk.models.Ticket;
import com.kindsonthegenius.fleetmvsv2.helpdesk.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    //Get VehicleHire By Id
    public Ticket findById(int id) {
        return ticketRepository.findById(id).orElse(null);
    }

    //Delete VehicleHire
    public void delete(int id) {
        ticketRepository.deleteById(id);
    }

    //Update VehicleHire
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }
}
