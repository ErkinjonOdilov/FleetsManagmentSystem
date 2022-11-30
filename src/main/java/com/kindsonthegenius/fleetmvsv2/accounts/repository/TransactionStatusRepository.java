package com.kindsonthegenius.fleetmvsv2.accounts.repository;
import com.kindsonthegenius.fleetmvsv2.accounts.models.Transaction;
import com.kindsonthegenius.fleetmvsv2.accounts.models.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Integer> {
}