package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.TicketDetails;
import com.movie.service.TicketService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

	@Autowired
	TicketService service;
	
	@PostMapping("/addTicket")
	public String addTicket(@RequestBody TicketDetails ticket) {
		return service.addDetails(ticket);
	}
	
	@GetMapping("/getTickets")
	public List<TicketDetails> getTicket(@RequestParam String uid) {
		return service.getTickets(uid);
	}

	
	@GetMapping("/getTicketsBySid")
	public List<TicketDetails> getTicketsBySid(@RequestParam String sid) {
		return service.getTicketsBySid(sid);
	}
}
