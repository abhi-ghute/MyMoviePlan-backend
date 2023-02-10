package com.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dto.Cast;
import com.movie.dto.MovieDto;
import com.movie.entiry.CastEntity;
import com.movie.entiry.MovieEntity;
import com.movie.repository.MovieRepository;

import jakarta.transaction.Transactional;

@Service
public class MovieService {

	@Autowired
	MovieRepository repo;

	public String saveMovie(MovieDto movie) {

		MovieEntity entity = new MovieEntity();
		BeanUtils.copyProperties(movie, entity);

		repo.save(entity);

		return "success";
	}

	public List<MovieEntity> getMovies() {

		List<MovieEntity> movieList = repo.findAll();

		return movieList;
	}
	
	@Transactional
	public String updateStatus(String status, Integer id) {
		
		Optional<MovieEntity> optional = repo.findById(id);	
		MovieEntity entity = optional.get();
		System.out.println("done");
		if(status.equalsIgnoreCase("Enable")) {
			entity.setStatus("Disable");
			return "Disable";
		}else {
			entity.setStatus("Enable");
			return "Enable";
		}
		
	}
}
