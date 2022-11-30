package com.kindsonthegenius.fleetmvsv2.parameters.services;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Client;
import com.kindsonthegenius.fleetmvsv2.parameters.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public void save(Client client){
        clientRepository.save(client);
    }

    public void delete(Integer id){
        clientRepository.deleteById(id);
    }

    public Client getById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }
}


