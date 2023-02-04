package com.movie.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.MovieDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("admin")
public class MovieController {

	@PostMapping("addMovie")
	public String saveMovie(@RequestBody MovieDto movie) {
		System.out.println(movie.getCast()[0].getImageData().substring(0,100));
		//System.out.println(movie.getCast()[1].getImage().substring(0,10));
		return "success";
	}
}
