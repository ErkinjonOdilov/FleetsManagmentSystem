package com.kindsonthegenius.fleetmvsv2.parameters.services;

import com.kindsonthegenius.fleetmvsv2.parameters.models.Country;
import com.kindsonthegenius.fleetmvsv2.parameters.models.State;
import com.kindsonthegenius.fleetmvsv2.parameters.repository.CountryRepository;
import com.kindsonthegenius.fleetmvsv2.parameters.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAll(){
        return stateRepository.findAll();
    }

    public void save(State state){
        stateRepository.save(state);
    }

    public void delete(Integer id){
        stateRepository.deleteById(id);
    }

    public State getById(Integer id) {
        return stateRepository.findById(id).orElse(null);
    }
}
