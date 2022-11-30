package com.kindsonthegenius.fleetmvsv2.helpdesk.controllers;

import com.kindsonthegenius.fleetmvsv2.helpdesk.models.Ticket;
import com.kindsonthegenius.fleetmvsv2.helpdesk.services.TicketService;
import com.kindsonthegenius.fleetmvsv2.helpdesk.services.TicketStatusService;
import com.kindsonthegenius.fleetmvsv2.hr.services.EmployeesService;
import com.kindsonthegenius.fleetmvsv2.parameters.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TicketController {
	
	@Autowired private TicketService ticketService;
	@Autowired private TicketStatusService ticketStatusService;
	@Autowired private ClientService clientService;
	@Autowired private EmployeesService employeesService;
	
	//Get All Tickets
	@GetMapping("/helpdesk/tickets")
	public String findAll(Model model){		
		model.addAttribute("tickets", ticketService.findAll());
		model.addAttribute("clients", clientService.getAll());
		model.addAttribute("ticketStatuses", ticketStatusService.findAll());
		return "/helpdesk/tickets";
	}

	@GetMapping("/helpdesk/ticketAdd")
	public String addEmployee(Model model){
		model.addAttribute("tickets", ticketService.findAll());
		model.addAttribute("clients", clientService.getAll());
		model.addAttribute("ticketStatuses", ticketStatusService.findAll());
		model.addAttribute("employees", employeesService.findAll());
		return "/helpdesk/ticketAdd";
	}

	@RequestMapping("/tickets/findById")
	@ResponseBody
	public Ticket findById(Integer id)
	{
		return ticketService.findById(id);
	}


	@PostMapping(value="/helpdesk/tickets")
	public String save(Ticket ticket) {
		ticketService.save(ticket);
		return "redirect:/helpdesk/tickets";
	}



	@RequestMapping(value="/tickets/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Ticket ticket) {
		ticketService.save(ticket);
		return "redirect:/ticketList";
	}
	
	@RequestMapping(value="/tickets/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		ticketService.delete(id);
		return "redirect:/ticketList";
	}
}