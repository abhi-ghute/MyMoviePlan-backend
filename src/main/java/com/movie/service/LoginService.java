package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dto.LoginDto;
import com.movie.entity.AdminEntity;
import com.movie.entity.UserEntity;
import com.movie.repository.AdminRepository;
//import com.movie.repository.AdminRepository;
import com.movie.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	public UserEntity UserloginCheck(LoginDto login) {
		UserEntity entity = userRepo.findByEmailAndPassword(login.getUserName(), login.getPassword());
		return entity;
	}
	
	public AdminEntity adminLoginCheck(LoginDto login) {
		AdminEntity entity = adminRepo.findByUserNameAndPassword(login.getUserName(), login.getPassword());
		return entity;
	}
	
	@Transactional
	public String changePassword(String userName,String password,String newPassword) {
		
		if(userName.equalsIgnoreCase("admin")) {
			AdminEntity entity =adminRepo.findByUserName(userName);
			if(entity.getPassword().equals(password)) {
				entity.setPassword(newPassword);
			}
			else {
				return "Old password is inccorrect";
			}
		}else {
			UserEntity entity= userRepo.findByEmail(userName);
			if(entity.getPassword().equals(password)) {
				entity.setPassword(newPassword);
			}else {
				return "Old password is inccorrect";
			}
		}
		return "success";
	}
	
	
}
