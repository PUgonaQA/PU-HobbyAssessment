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
		if(optionalDish.isPresent()) {
			return optionalDish.get();
		}
		return null;
	}
	
	//Delete
	public boolean remove(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

	//Update
	public ResturauntHobby update(Long id, ResturauntHobby rest) {
		Optional<ResturauntHobby> existingOptional = repo.findById(id);
		
		if(existingOptional.isPresent()) {
			ResturauntHobby existing = existingOptional.get();
			
			existing.setId(id);
			existing.setDish(rest.getDish());
			existing.setLocation(rest.getLocation());
			existing.setRating(rest.getRating());
			existing.setRestaurantName(rest.getRestaurantName());
					
			return this.repo.save(existing);
		}
		return null;
	}
	
	
}


