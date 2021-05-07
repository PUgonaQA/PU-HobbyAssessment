package com.qa.ResturauntHobby.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.ResturauntHobby.domain.ResturauntHobby;
import com.qa.ResturauntHobby.service.ResturauntHobbyService;

@RestController
@CrossOrigin
public class ResturauntHobbyController {
	
	private ResturauntHobbyService service;
	
	public ResturauntHobbyController(ResturauntHobbyService service) {
		this.service = service;
	}
	
	//Create (CRUD)
	@PostMapping("/create")
	public ResponseEntity<ResturauntHobby> createDish(@RequestBody ResturauntHobby resturauntHobby) {
		return new ResponseEntity<ResturauntHobby>(this.service.create(resturauntHobby),HttpStatus.CREATED);
	}
	
	//Read (CRUD)
	@GetMapping("/getAll")
	public ResponseEntity<List<ResturauntHobby>> getResturauntHobby() {
		return ResponseEntity.ok(this.service.getAll());
	}
	

}
