package com.kindsonthegenius.fleetmvsv2.accounts.repository;
import com.kindsonthegenius.fleetmvsv2.accounts.models.Invoice;
import com.kindsonthegenius.fleetmvsv2.accounts.models.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Integer> {
}