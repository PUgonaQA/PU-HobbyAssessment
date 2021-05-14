package com.qa.ResturauntHobby.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "restaurant_hobby")
public class ResturauntHobby {
	
	@Id //Specifies the primary key for the table
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String restaurantName;
	
	@NotNull
	private String location;
	
	@NotNull
	private String dish;
	
	@NotNull
	private Integer rating;
	
	
	
	//Constructor without the ID (auto-increment)
	public ResturauntHobby(String restaurantName, String location, String dish, Integer rating) {
		super();
		this.restaurantName = restaurantName;
		this.location = location;
		this.dish = dish;
		this.rating = rating;
	}

	//Constructors with the ID
	public ResturauntHobby(Long id, String restaurantName, String location, String dish, Integer rating) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.location = location;
		this.dish = dish;
		this.rating = rating;
	}
	
	//Empty Constructor
	public ResturauntHobby() {
	}


	//Getters and setters for the table objects
	public Long getId() {
		return id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public String getLocation() {
		return location;
	}

	public String getDish() {
		return dish;
	}

	public Integer getRating() {
		return rating;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dish == null) ? 0 : dish.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResturauntHobby other = (ResturauntHobby) obj;
		if (dish == null) {
			if (other.dish != null)
				return false;
		} else if (!dish.equals(other.dish))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		return true;
	}
}
