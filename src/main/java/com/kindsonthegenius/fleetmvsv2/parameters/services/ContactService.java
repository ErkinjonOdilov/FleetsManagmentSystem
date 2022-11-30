package com.kindsonthegenius.fleetmvsv2.parameters.services;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Contact;
import com.kindsonthegenius.fleetmvsv2.parameters.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAll(){
       return contactRepository.findAll();
    }

    public void save(Contact contact){
        contactRepository.save(contact);
    }

    public void delete(Integer id){
        contactRepository.deleteById(id);
    }

    public Contact getById(Integer id){
      return contactRepository.findById(id).orElse(null);
    }

}
