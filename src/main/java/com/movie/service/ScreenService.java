package com.movie.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dto.ScreenDto;
import com.movie.entiry.ScreenEntity;
import com.movie.repository.ScreenReopository;

@Service
public class ScreenService {

	@Autowired
	ScreenReopository repo;
	
	public ScreenDto getSeats(String screen) {
		ScreenEntity entity = repo.findByScreenNumber(screen);
		System.out.println("hhh");
		ScreenDto screenDto = new ScreenDto();
		BeanUtils.copyProperties(entity, screenDto);
		
		return screenDto;
	}
}
