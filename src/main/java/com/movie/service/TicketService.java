package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entity.TicketDetails;
import com.movie.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository repo;
	
	public String addDetails(TicketDetails ticket) {
		repo.save(ticket);
		return "success";
	}
	
	public List<TicketDetails> getTickets(String uid) {
		return repo.findByUid(uid);
	}
	
	public List<TicketDetails> getTicketsBySid(String sid) {
		return repo.findBySid(sid);
	}
}
