package com.kindsonthegenius.fleetmvsv2.parameters.controllers;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Client;
import com.kindsonthegenius.fleetmvsv2.parameters.models.Contact;
import com.kindsonthegenius.fleetmvsv2.parameters.models.Location;
import com.kindsonthegenius.fleetmvsv2.parameters.services.ClientService;
import com.kindsonthegenius.fleetmvsv2.parameters.services.CountryService;
import com.kindsonthegenius.fleetmvsv2.parameters.services.LocationService;
import com.kindsonthegenius.fleetmvsv2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;

    public Model addModelAttributes(Model model){
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.getAll());
        return model;
    }

    @GetMapping("/parameters/clients")
    public String findAll(Model model){
        addModelAttributes(model);
        return "/parameters/clients";
    }

    @GetMapping("/parameters/clientAdd")
    public String addClient(Model model){
        model.addAttribute("countries", countryService.findAll());
        return "parameters/clientAdd";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/parameters/client/{op}/{id}")
    public String editClient(@PathVariable Integer id, @PathVariable String op, Model model){
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        addModelAttributes(model);
        return "/parameters/client"+ op; //returns clientEdit or clientDetails
    }

    @PostMapping("/parameters/clients")
    public String save(Client client) {
        clientService.save(client);
        return "redirect:/parameters/clients";
    }

    @RequestMapping(value="/parameters/clients/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@PathVariable Integer id) {
        clientService.delete(id);
        return "redirect:/parameters/clients";
    }
    @RequestMapping(value = "/client/update/{id}", method ={RequestMethod.GET, RequestMethod.PUT})
    public String delete(Client client){
        clientService.save(client);
        return "redirect:/parameters/clients";
    }

}