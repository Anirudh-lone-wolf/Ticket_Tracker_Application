package com.glearning.Project.service;

import java.util.List;

import com.glearning.Project.model.Ticket;

public interface TicketTrackerService {

	Ticket saveTicket(Ticket ticket);

	List<Ticket> fetchAllTickets();

	Ticket getTicketById(long id);

	List<Ticket> findTicketByTitleOrDescprition(String query);

	void deleteTicket(long id);

}