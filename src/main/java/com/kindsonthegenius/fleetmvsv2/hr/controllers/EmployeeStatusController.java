package com.kindsonthegenius.fleetmvsv2.hr.controllers;

import com.kindsonthegenius.fleetmvsv2.hr.models.EmployeeStatus;
import com.kindsonthegenius.fleetmvsv2.hr.models.EmployeeType;
import com.kindsonthegenius.fleetmvsv2.hr.services.EmployeeStatusService;
import com.kindsonthegenius.fleetmvsv2.hr.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeStatusController {
    @Autowired
    private EmployeeStatusService employeeStatusService;

    @GetMapping("hr/employeeStatuses")
    public String getAll(Model model){
        List<EmployeeStatus> employeeStatuses=employeeStatusService.findAll();
        model.addAttribute("employeeStatuses",employeeStatuses);
        return "hr/employeeStatuses";
    }

    @GetMapping("hr/employeeStatus/{id}")
    @ResponseBody
    public EmployeeStatus getById(@PathVariable Integer id){
        return employeeStatusService.findById(id);
    }

    @PostMapping("hr/employeeStatuses")
    public String addNew(EmployeeStatus employeeStatus){
        employeeStatusService.save(employeeStatus);
        return "redirect:/hr/employeeStatuses";
    }


    @RequestMapping(value="/hr/employeeStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        employeeStatusService.delete(id);
        return "redirect:/hr/employeeStatuses";
    }
}

