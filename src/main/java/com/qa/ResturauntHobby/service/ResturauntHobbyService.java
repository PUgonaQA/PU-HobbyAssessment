package com.qa.ResturauntHobby.service;

import java.util.List;
import java.util.Optional;

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
	
	// getById needed to delete or update a field in the table
	public ResturauntHobby getById(Long id) {
		Optional<ResturauntHobby> optionalDish = this.repo.findById(id);
		return optionalDish.get();
	}
	
	//Delete
	public boolean remove(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

	//Update
	public ResturauntHobby update(Long id, ResturauntHobby rest) {
		Optional<ResturauntHobby> updateDish = this.repo.findById(id);
		updateDish.get().setId(id);
		return this.repo.save(rest);
	}
	
	
}


