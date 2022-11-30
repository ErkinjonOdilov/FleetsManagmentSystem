package com.kindsonthegenius.fleetmvsv2.accounts.controllers;


import com.kindsonthegenius.fleetmvsv2.accounts.models.Invoice;
import com.kindsonthegenius.fleetmvsv2.accounts.services.InvoiceService;
import com.kindsonthegenius.fleetmvsv2.accounts.services.InvoiceStatusService;
import com.kindsonthegenius.fleetmvsv2.parameters.models.Client;
import com.kindsonthegenius.fleetmvsv2.parameters.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class InvoiceController {
	
	@Autowired private InvoiceService invoiceService;
	@Autowired private InvoiceStatusService invoiceStatusService;
	@Autowired private ClientService clientService;
	

	@GetMapping("/accounts/invoices")
	public String  getAll(Model model){
		List<Invoice> invoices =   invoiceService.findAll();
		model.addAttribute("invoices", invoices);
		return "/accounts/invoices";
	}

	@GetMapping("/accounts/invoiceAdd")
	public String addInvoice(Model model){
		model.addAttribute("clients", clientService.getAll());
		model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
		return "accounts/invoiceAdd";
	}

	@GetMapping("/accounts/invoice/{op}/{id}")
	public String editInvoice(@PathVariable Integer id, @PathVariable String op, Model model){
		Invoice invoice = invoiceService.findById(id);
		model.addAttribute("invoice", invoice);
		model.addAttribute("clients", clientService.getAll());
		model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
		return "/accounts/invoice"+ op;
	}

	@PostMapping("/accounts/invoices")
	public String save(Invoice invoice){
		invoiceService.save(invoice);
		return "redirect:/accounts/invoices";
	}

	@RequestMapping(value = "/accounts/invoice/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public  String delete(@PathVariable Integer id){
		invoiceService.delete(id);
		return "redirect:/accounts/invoices";
	}

	@RequestMapping(value = "/accounts/invoice/update/{id}", method ={RequestMethod.GET, RequestMethod.PUT})
	public String update(Invoice invoice){
		invoiceService.save(invoice);
		return "redirect:/accounts/invoices";
	}
}