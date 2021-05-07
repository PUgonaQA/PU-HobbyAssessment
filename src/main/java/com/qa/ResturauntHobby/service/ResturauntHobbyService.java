package com.qa.ResturauntHobby.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.ResturauntHobby.domain.ResturauntHobby;
import com.qa.ResturauntHobby.repo.ResturauntHobbyRepo;

@Service
public class ResturauntHobbyService {

	private ResturauntHobbyRepo repo;
	
	public ResturauntHobbyService(ResturauntHobbyRepo repo) {
		this.repo = repo;
	}
	
	public ResturauntHobby create(ResturauntHobby r) {
		return this.repo.save(r);
	}
	
	public List<ResturauntHobby> getAll() {
		return this.repo.findAll();		
	}
	
//	public ResturauntHobby getById(Long id) {
//		Optional<ResturauntHobby> optionalDish = this.repo.findById(id);
//		return optionalDish.get();
//	}
}
