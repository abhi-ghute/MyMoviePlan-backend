package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.MovieDto;
import com.movie.entiry.MovieEntity;
import com.movie.service.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("admin")
public class MovieController {

	@Autowired
	MovieService service;
	
	@PostMapping("addMovie")
	public String saveMovie(@RequestBody MovieDto movie) {
		service.saveMovie(movie);
		return "success";
	}
	
	@GetMapping("moviesList")
	public List<MovieEntity> getMovies() {
		return service.getMovies();
	}
	
	@PostMapping("updateStatus")
	public String updateStatus(@RequestParam String status,@RequestParam Integer id) {
		return service.updateStatus(status,id);
	}
	
}
