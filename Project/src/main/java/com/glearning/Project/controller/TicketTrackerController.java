package com.glearning.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.Project.model.Ticket;
import com.glearning.Project.service.TicketTrackerService;

@Controller
@RequestMapping("/admin/tickets")
public class TicketTrackerController {

	@Autowired
	TicketTrackerService ticketTrackerService;

	@GetMapping
	public String listOfTickets(Model model) {
		List<Ticket> tickets = ticketTrackerService.fetchAllTickets();
		model.addAttribute("tickets", tickets);
		return "ui/homepage";
	}

	@GetMapping("/view")
	public String viewTicket(@RequestParam("id") long id, Model model) {	
		Ticket ticket = ticketTrackerService.getTicketById(id);	
		model.addAttribute("viewTicket", ticket);
		return "ui/viewticket";
	}

	@GetMapping("/newticket")
	public String createTicket() {
		return "ui/addnew";
	}

	@PostMapping("/addTicket")
	public String saveCreatedTicket(@ModelAttribute Ticket createTicket) {
		ticketTrackerService.saveTicket(createTicket);
		return "redirect:/admin/tickets";
	}

	@PostMapping("/edit")
	public String editTicket(@RequestParam("id") long id, Model model) {
		Ticket editTicket = ticketTrackerService.getTicketById(id);
		model.addAttribute("editTicket", editTicket);
		return "ui/editticket";
	}

	@GetMapping("/search")
	public String searchTickets(@RequestParam("searchString") String searchString, Model model) {
		List<Ticket> searchTickets;
		if (searchString != null && !searchString.trim().isEmpty()) {
			searchTickets = ticketTrackerService.findTicketByTitleOrDescprition(searchString);
		} else {
			searchTickets = ticketTrackerService.fetchAllTickets();
		}
		model.addAttribute("searchString", searchString);
		model.addAttribute("tickets", searchTickets);
		return "ui/homepage";
	}

	@PostMapping("/delete")
	public String deleteTicket(@RequestParam("id") long id) {
		ticketTrackerService.deleteTicket(id);
		return "redirect:/admin/tickets";
	}

}
