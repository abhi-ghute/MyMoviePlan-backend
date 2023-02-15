package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.LoginDto;
import com.movie.entity.AdminEntity;
import com.movie.entity.UserEntity;
import com.movie.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@PostMapping("/login")
	public UserEntity login(@RequestBody LoginDto login) {
		return service.UserloginCheck(login);
	}
	@PostMapping("/adminLogin")
	public AdminEntity adminLogin(@RequestBody LoginDto login) {
		return service.adminLoginCheck(login);
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam String userName,@RequestParam String password,@RequestParam String newPassword) {
		System.out.println("asd");
		return service.changePassword(userName,password,newPassword);
	}
}
