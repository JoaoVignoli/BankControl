package com.vignoli.bank.repositories;

import com.vignoli.bank.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, Integer> {
}
