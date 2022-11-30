package com.kindsonthegenius.fleetmvsv2.hr.controllers;

import com.kindsonthegenius.fleetmvsv2.accounts.models.TransactionStatus;
import com.kindsonthegenius.fleetmvsv2.hr.models.JobTitle;
import com.kindsonthegenius.fleetmvsv2.hr.repository.JobTitleRepository;
import com.kindsonthegenius.fleetmvsv2.hr.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/hr/jobTitles")
    public String getAll(Model model){
        List<JobTitle> jobTitles = jobTitleService.findAll();
        model.addAttribute("jobTitles", jobTitles);
        return "hr/jobTitles";
    }

    //Get Job Title by id
    @GetMapping("/hr/jobTitle/{id}")
    @ResponseBody
    public JobTitle getById(@PathVariable Integer id){
        return jobTitleService.findById(id);
    }

    //Add TransactionType
    @PostMapping("/hr/jobTitles")
    public String addNew(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/hr/jobTitles";
    }

    @RequestMapping(value="/hr/jobTitle/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        jobTitleService.delete(id);
        return "redirect:/hr/jobTitles";
    }
}
