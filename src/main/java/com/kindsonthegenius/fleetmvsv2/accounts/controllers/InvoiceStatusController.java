package com.kindsonthegenius.fleetmvsv2.accounts.controllers;

import com.kindsonthegenius.fleetmvsv2.accounts.models.InvoiceStatus;
import com.kindsonthegenius.fleetmvsv2.accounts.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InvoiceStatusController {

	@Autowired private InvoiceStatusService invoiceStatusService;

	@GetMapping("/accounts/invoiceStatuses")
	public String findAll(Model model){
		model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
		return "/accounts/invoiceStatuses";
	}

	@RequestMapping("/accounts/invoiceStatus/{id}")
	@ResponseBody
	public InvoiceStatus findById(@PathVariable Integer id)
	{
		return invoiceStatusService.findById(id);
	}

	@PostMapping(value="/accounts/invoiceStatuses")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/accounts/invoiceStatuses";
	}

	@RequestMapping(value="accounts/invoiceStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}
}