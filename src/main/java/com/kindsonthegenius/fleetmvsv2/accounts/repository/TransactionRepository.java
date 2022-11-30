package com.kindsonthegenius.fleetmvsv2.accounts.repository;
import com.kindsonthegenius.fleetmvsv2.accounts.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}