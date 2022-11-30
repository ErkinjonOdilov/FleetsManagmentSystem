package com.kindsonthegenius.fleetmvsv2.accounts.controllers;

import com.kindsonthegenius.fleetmvsv2.accounts.models.TransactionStatus;
import com.kindsonthegenius.fleetmvsv2.accounts.services.TransactionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransactionStatusController {

    @Autowired
    private TransactionStatusService transactionStatusService;

    @GetMapping("/accounts/transactionStatuses")
    public String parameters(Model model){
        List<TransactionStatus> transactionStatuses = transactionStatusService.findAll();
        model.addAttribute("transactionStatuses", transactionStatuses);
        return "accounts/transactionStatuses";
    }


    @GetMapping("/accounts/transactionStatus/{id}")
    @ResponseBody
    public TransactionStatus getById(@PathVariable Integer id){
        return transactionStatusService.findById(id);
    }


    @PostMapping("/accounts/transactionStatuses")
    public String addNew(TransactionStatus transactionStatus) {
        transactionStatusService.save(transactionStatus);
        return "redirect:/accounts/transactionStatuses";
    }

    @RequestMapping(value="/accounts/transactionStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        transactionStatusService.delete(id);
        return "redirect:/accounts/transactionStatuses";
    }

}