package com.alweimine.banquesi.services;

import com.alweimine.banquesi.entities.Client;

import java.util.List;

public interface ClientService {
    public Client saveClient(Client c);
    public List<Client> listClient();
}
