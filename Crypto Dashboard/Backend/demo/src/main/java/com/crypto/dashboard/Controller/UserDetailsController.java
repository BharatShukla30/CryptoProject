package com.crypto.dashboard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crypto.dashboard.Entity.UserDetails;
import com.crypto.dashboard.Repository.UserDetailsRepository;
import com.crypto.dashboard.Service.Message;
import com.crypto.dashboard.dto.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "${allowed.cors.origins}", allowedHeaders = "${allowed.cors.headers}")
@RequestMapping("/user-data")
@RestController
public class UserDetailsController {
	
	@Autowired
	private UserDetailsRepository userDetailsRepo;
	
	@GetMapping(value="/getuser")
	public ResponseEntity<Object> getUserData(@RequestParam("username") String userName){
		UserDetails userDetailsRow = userDetailsRepo.findByUsername(userName);
		return new ResponseEntity<>(userDetailsRow, HttpStatus.ACCEPTED);
	}
	@PostMapping(value="/saveuser")
	public ResponseEntity<Object> setUserData(@RequestBody UserInfo userInfo){
		return new ResponseEntity<>(new Message("User saved successfully"), HttpStatus.ACCEPTED);
	}
	
}