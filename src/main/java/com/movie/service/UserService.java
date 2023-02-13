package com.movie.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dto.UserDto;
import com.movie.entity.UserEntity;
import com.movie.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public String saveUser(UserDto user) {

		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		repository.save(entity);

		return "success";

	}
}
