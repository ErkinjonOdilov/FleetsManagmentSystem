package com.kindsonthegenius.fleetmvsv2.hr.controllers;

import com.kindsonthegenius.fleetmvsv2.hr.models.EmployeeType;
import com.kindsonthegenius.fleetmvsv2.hr.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("hr/employeeTypes")
    public String getAll(Model model){
        List<EmployeeType> employeeTypes=employeeTypeService.findAll();
        model.addAttribute("employeeTypes",employeeTypes);
        return "hr/employeeTypes";
    }

    @GetMapping("hr/employeeType/{id}")
    @ResponseBody
    public EmployeeType getById(@PathVariable Integer id){
        return employeeTypeService.findById(id);
    }

    @PostMapping("hr/employeeTypes")
    public String addNew(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/hr/employeeTypes";
    }


    @RequestMapping(value="/hr/employeeType/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        employeeTypeService.delete(id);
        return "redirect:/hr/employeeTypes";
    }
}
