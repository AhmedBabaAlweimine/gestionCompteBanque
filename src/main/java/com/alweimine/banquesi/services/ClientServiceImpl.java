package com.alweimine.banquesi.services;

import com.alweimine.banquesi.entities.Client;
import com.alweimine.banquesi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client saveClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public List<Client> listClient() {
        return clientRepository.findAll();
    }
}
