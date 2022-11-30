package com.kindsonthegenius.fleetmvsv2.helpdesk.repository;

import com.kindsonthegenius.fleetmvsv2.helpdesk.models.Ticket;
import com.kindsonthegenius.fleetmvsv2.helpdesk.models.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Integer> {
}
