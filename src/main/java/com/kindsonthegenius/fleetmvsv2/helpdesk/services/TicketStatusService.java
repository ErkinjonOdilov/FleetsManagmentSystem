package com.kindsonthegenius.fleetmvsv2.helpdesk.services;

import com.kindsonthegenius.fleetmvsv2.helpdesk.models.Ticket;
import com.kindsonthegenius.fleetmvsv2.helpdesk.models.TicketStatus;
import com.kindsonthegenius.fleetmvsv2.helpdesk.repository.TicketRepository;
import com.kindsonthegenius.fleetmvsv2.helpdesk.repository.TicketStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketStatusService {
    @Autowired
    private TicketStatusRepository ticketStatusRepository;

    public List<TicketStatus> findAll(){
        return ticketStatusRepository.findAll();
    }

    //Get VehicleHire By Id
    public TicketStatus findById(int id) {
        return ticketStatusRepository.findById(id).orElse(null);
    }

    //Delete VehicleHire
    public void delete(int id) {
        ticketStatusRepository.deleteById(id);
    }

    //Update VehicleHire
    public void save(TicketStatus ticket) {
        ticketStatusRepository.save(ticket);
    }
}
