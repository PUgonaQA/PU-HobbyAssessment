package com.qa.ResturauntHobby.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.ResturauntHobby.domain.ResturauntHobby;

@Repository //Logic layer entity Repository  
public interface ResturauntHobbyRepo extends JpaRepository<ResturauntHobby, Long> {

}
