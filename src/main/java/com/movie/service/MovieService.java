package com.movie.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.dto.MovieDto;
import com.movie.dto.ShowDto;
import com.movie.entity.MovieEntity;
import com.movie.entity.ShowEntity;
import com.movie.repository.MovieRepository;
import com.movie.repository.ShowRepository;

import jakarta.transaction.Transactional;

@Service
public class MovieService {

	List<ShowEntity> originalMovieList;
	@Autowired
	MovieRepository repo;

	@Autowired
	ShowRepository showRepo;

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
	
	public List<MovieEntity> showEnableMovies() {

		List<MovieEntity> movieList = repo.findByStatus("Enable");

		return movieList;
	}

	@Transactional
	public String updateStatus(String status, Integer id) {

		Optional<MovieEntity> optional = repo.findById(id);
		MovieEntity entity = optional.get();
		System.out.println("done");
		if (status.equalsIgnoreCase("Enable")) {
			entity.setStatus("Disable");
			return "Disable";
		} else {
			entity.setStatus("Enable");
			return "Enable";
		}

	}

	public String addShow(ShowDto showDto) {
		ShowEntity entity = new ShowEntity();
		BeanUtils.copyProperties(showDto, entity);
		System.out.println(showDto.getScreenNumber());
		List<ShowEntity> showList = showRepo.findAll();

		for (ShowEntity s : showList) {
			if (s.getDate().equals(entity.getDate()) && s.getTime().equals(entity.getTime())
					&& s.getScreenNumber().equals(entity.getScreenNumber()))
				return "occupied";
		}
		showRepo.save(entity);
		return "success";
	}

	public List<MovieEntity> showList() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		List<ShowEntity> showList = showRepo.findAll();
		originalMovieList = new ArrayList<>(showList);
		
		List<Integer> ids = new ArrayList<>();
		
		for (ShowEntity s : showList) {
			Date movieDate = (Date) formatter.parse(s.getDate() + " " + s.getTime());
			System.out.println(movieDate);

			Date cdate = new Date();
			Date currentDate = formatter.parse(formatter.format(cdate));
			System.out.println(currentDate);

			int result = movieDate.compareTo(currentDate);
			if (result <0) {
				originalMovieList.remove(s);
			}else {
				ids.add(Integer.parseInt(s.getId()));
			}
		}
		
		Collections.sort(originalMovieList, new Comparator<ShowEntity>() {
			@Override
			public int compare(ShowEntity o1, ShowEntity o2) {
				try {
		            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		            Date date1 = formatter.parse(o1.getDate()+" "+o1.getTime());
		            Date date2 = formatter.parse(o2.getDate()+" "+o2.getTime());
		            return date1.compareTo(date2);
		        } catch (Exception e) {
		            System.out.println("Unable to parse date: " + e.getMessage());
		        }
		        return 0;
			}
		});
		
		List<MovieEntity> moviesList = repo.findAllById(ids);
		
		return moviesList;
	}
	
	public MovieEntity selectMovie(Integer id) {
		return repo.findById(id).get();
	}
	
	public List<MovieEntity> getUpcomming() throws ParseException{
		LocalDate today = LocalDate.now();
	
		
		List<MovieEntity> movieList = repo.findAll();
		List<MovieEntity> previousoriginalMovieList = new ArrayList<>();
		List<ShowEntity> showList = showRepo.findAll();
		
		for (MovieEntity m : movieList) {
			for(ShowEntity s:showList) {
				if(s.getId().equalsIgnoreCase(m.getId()+"")) {
					LocalDate futureDate = LocalDate.parse(m.getReleaseDate());
				    Period difference = Period.between(today, futureDate);
				    System.out.println(difference.getDays());
					if(difference.getDays() >= 1) {
						previousoriginalMovieList.add(m);
					}
				}
			}
			
		}
		return previousoriginalMovieList;
	}
	
	public ShowEntity getShowDetails(String id) {
		for(ShowEntity s: originalMovieList) {
			if(s.getId().equals(id)) {
				return s;
			}
		}
		return null;
	}
	
	public ShowEntity getShow(Integer id) {
		return showRepo.findById(id).get();
	}
}
