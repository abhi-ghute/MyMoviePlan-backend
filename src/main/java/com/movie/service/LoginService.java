package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dto.LoginDto;
import com.movie.entity.UserEntity;
//import com.movie.repository.AdminRepository;
import com.movie.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepo;
	
//	@Autowired
//	AdminRepository adminRepo;
	
	public UserEntity UserloginCheck(LoginDto login) {
		
		
		UserEntity entity = userRepo.findByEmailAndPassword(login.getUserName(), login.getPassword());
		return entity;
		
	}
	
}
