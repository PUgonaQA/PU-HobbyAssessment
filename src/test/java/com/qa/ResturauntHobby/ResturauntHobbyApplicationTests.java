package com.qa.ResturauntHobby;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.ResturauntHobby.controller.ResturauntHobbyController;
import com.qa.ResturauntHobby.service.ResturauntHobbyService;

@SpringBootTest
class ResturauntHobbyApplicationTests {

	@Autowired
	private ResturauntHobbyController hobbyController;
	
	@Autowired
	private ResturauntHobbyService hobbyService;
	
	@Test
	void contextLoads() {
		
		assertThat(hobbyController).isNotNull();
		assertThat(hobbyService).isNotNull();
	}

}
