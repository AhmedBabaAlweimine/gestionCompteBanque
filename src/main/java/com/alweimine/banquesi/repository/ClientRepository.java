package com.alweimine.banquesi.repository;

import com.alweimine.banquesi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
