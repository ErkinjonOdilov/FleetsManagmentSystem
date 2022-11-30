package com.kindsonthegenius.fleetmvsv2.accounts.repository;
import com.kindsonthegenius.fleetmvsv2.accounts.models.Transaction;
import com.kindsonthegenius.fleetmvsv2.accounts.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {
}