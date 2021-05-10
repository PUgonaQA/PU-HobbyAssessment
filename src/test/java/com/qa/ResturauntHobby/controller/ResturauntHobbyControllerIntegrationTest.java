package com.qa.ResturauntHobby.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.ResturauntHobby.domain.ResturauntHobby;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema.sql","classpath:data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ResturauntHobbyControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		ResturauntHobby kfc = new ResturauntHobby("KFC","London,UK","Zinger meal",45);
		String kfcAsJSON = this.mapper.writeValueAsString(kfc);
		
		RequestBuilder mockRequest = post("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(kfcAsJSON);
		
		ResturauntHobby savedKfc = new ResturauntHobby(3L,"KFC","London,UK","Zinger meal",45);
		String savedKfcAsJSON = this.mapper.writeValueAsString(savedKfc);
		
		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(savedKfcAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}

	@Test
	void testUpdate() throws Exception {
		ResturauntHobby kfc = new ResturauntHobby("KFC","London,UK","Popcorn Chicken meal",55);
		String kfcAsJSON = this.mapper.writeValueAsString(kfc);
		
		RequestBuilder mockRequest = put("/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(kfcAsJSON);
		
		ResturauntHobby savedKfc = new ResturauntHobby(1L,"KFC","London,UK","Popcorn Chicken meal",55);
		String savedKfcAsJSON = this.mapper.writeValueAsString(savedKfc);
		
		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(savedKfcAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
	
	@Test
	void testRemove() throws Exception {
		
		//Removes the entity in the data.sql file where id=1
		RequestBuilder mockRequest = delete("/remove/1")
				.contentType(MediaType.APPLICATION_JSON);		
		
		//As a result of the successful delete, the status code 200 is returned
		ResultMatcher matchStatus = status().isOk();
		this.mockMVC.perform(mockRequest).andExpect(matchStatus);
	}
	
	@Test
	void testReadAll() throws Exception {		
		RequestBuilder mockRequest = get("/getAll")
				.contentType(MediaType.APPLICATION_JSON);
		
		//Matches the JSON Object with a JSON Object
		String savedVaps = "[{\"id\":1,\"restaurantName\":\"Vapianos\",\"location\":\"London UK\",\"dish\":\"Chicken and Mushroom Risotto\",\"rating\":71},"
				+ "{\"id\":2,\"restaurantName\":\"TGI Friday\",\"location\":\"Southampton UK\",\"dish\":\"JD Wings\",\"rating\":80}]";
		
		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(savedVaps);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus)
		.andExpect(matchBody);
	}
	
	@Test
	void testReadOne() throws Exception {		
		RequestBuilder mockRequest = get("/getOne/2")
				.contentType(MediaType.APPLICATION_JSON);
		
		//Matches the JSON Object with a JSON Object
		String savedVaps = "{\"id\":2,\"restaurantName\":\"TGI Friday\",\"location\":\"Southampton UK\",\"dish\":\"JD Wings\",\"rating\":80}";
		
		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(savedVaps);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus)
		.andExpect(matchBody);
	}
}

