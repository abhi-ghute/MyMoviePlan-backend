package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.ScreenDto;
import com.movie.service.ScreenService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScreenController {

	@Autowired
	ScreenService service;
	
	@GetMapping("screenData")
	public ScreenDto screenData(@RequestParam String screen) {
		return service.getSeats(screen);
	}
}
