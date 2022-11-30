package com.kindsonthegenius.fleetmvsv2.parameters.controllers;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Country;
import com.kindsonthegenius.fleetmvsv2.parameters.models.State;
import com.kindsonthegenius.fleetmvsv2.parameters.services.CountryService;
import com.kindsonthegenius.fleetmvsv2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class StateController {

    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    public Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries", countryService.findAll());
        return model;
    }

    @GetMapping("/parameters/states")
    public String  getAll(Model model){
     addModelAttribute(model);
        return "/parameters/states";
    }

    @GetMapping("/parameters/stateAdd")
    public String  addState(Model model){
      addModelAttribute(model);
        return "parameters/stateAdd";
    }

    @GetMapping("/parameters/state/{op}//{id}")
    public String editState(@PathVariable Integer id, @PathVariable String op, Model model){
      addModelAttribute(model);
      model.addAttribute("state",stateService.getById(id));
        return "/parameters/state"+op;
    }

    @PostMapping(value = "/parameters/states")
    public String addNew(State state){
        stateService.save(state);
        return "redirect:/parameters/states";
    }


    @RequestMapping(value = "/parameters/state/delete/{id}", method ={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        stateService.delete (id);
        return "redirect:/parameters/states";
    }

    @RequestMapping(value = "/parameters/states/update/{id}", method ={RequestMethod.GET, RequestMethod.PUT})
    public String update(State state){
        stateService.save(state);
        return "redirect:/parameters/states";
    }
}
