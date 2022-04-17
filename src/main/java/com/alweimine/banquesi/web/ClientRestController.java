package com.alweimine.banquesi.web;

import com.alweimine.banquesi.entities.Client;
import com.alweimine.banquesi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientRestController {
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/clients",method = RequestMethod.POST)
    public Client saveClient(@RequestBody  Client c) {
        return clientService.saveClient(c);
    }

    @RequestMapping(value = "/clients",method = RequestMethod.GET)
    public List<Client> listClient() {
        return clientService.listClient();
    }
}
