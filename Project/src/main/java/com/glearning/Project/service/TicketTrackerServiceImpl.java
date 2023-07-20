package com.glearning.Project.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.Project.dao.TicketRepository;
import com.glearning.Project.model.Ticket;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TicketTrackerServiceImpl implements TicketTrackerService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> fetchAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(long id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);

		if (ticket.isPresent())
			return ticket.get();
		throw new EntityNotFoundException("This Ticket does not exist");
	}

	@Override
	public List<Ticket> findTicketByTitleOrDescprition(String query) {
	

		return ticketRepository.findByKeyword(query);
	}

	@Override
	public void deleteTicket(long id) {
		Ticket ticket = getTicketById(id);
		if (ticket != null)
			ticketRepository.delete(ticket);
		else
			throw new EntityNotFoundException("This Ticket does not exist");
	}

}
