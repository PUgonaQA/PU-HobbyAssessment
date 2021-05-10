package com.qa.ResturauntHobby.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.ResturauntHobby.domain.ResturauntHobby;
import com.qa.ResturauntHobby.repo.ResturauntHobbyRepo;

@SpringBootTest
public class ResturauntHobbyServiceUnitTest {
	
	@Autowired
	private ResturauntHobbyService service;
	
	@MockBean
	private ResturauntHobbyRepo repo;
	
	
	@Test
	void testCreate() {
		ResturauntHobby nandos = new ResturauntHobby("Nandos", "Brighton UK", "Hot Half Chciken", 70);
		ResturauntHobby savedNandos = new ResturauntHobby(1L, "Nandos", "Brighton UK", "Hot Half Chciken", 70);
		
		Mockito.when(this.repo.save(nandos)).thenReturn(savedNandos);
		
		assertThat(this.service.create(nandos)).isEqualTo(savedNandos);
		Mockito.verify(this.repo, Mockito.times(1)).save(nandos); 
	}
	
	@Test
	void testReadAll() {
		ResturauntHobby testNandos = new ResturauntHobby(1L, "Nandos", "Brighton UK", "Hot Half Chciken", 70);
		ResturauntHobby testVapianos = new ResturauntHobby(2L, "Vapianos", "London UK", "Carbonara", 65);
	
		List<ResturauntHobby> restaurants = List.of(testNandos, testVapianos);
		
		Mockito.when(this.repo.findAll()).thenReturn(restaurants);
		assertThat(this.service.getAll()).isEqualTo(restaurants);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testDelete() {
		Long id=1L;
		ResturauntHobby deleteNandos = new ResturauntHobby(id, "Nandos", "Brighton UK", "Hot Half Chciken", 70);
		ResturauntHobby savedNandos = new ResturauntHobby(1L, "Nandos", "Brighton UK", "Hot Half Chciken", 70);
		Mockito.when(this.repo.save(deleteNandos)).thenReturn(savedNandos);
		
		boolean exists = this.repo.existsById(id);
		
		Mockito.when(!exists).thenReturn(true);
		assertThat(this.service.remove(id)).isFalse();
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}
	
	@Test
	void testReadById() {
		Long id = 1L;
		ResturauntHobby dominos = new ResturauntHobby(id, "Dominos", "London UK", "Veggie Pizza", 55);
		
		Optional<ResturauntHobby> optDominos = Optional.of(dominos);
		assertThat(optDominos.isPresent()); 
		
		Mockito.when(this.repo.findById(id)).thenReturn(optDominos);
		
		assertThat(this.service.getById(id)).isEqualTo(dominos);
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	@Test 
	void testUpdate() {
		Long id=1L;
		ResturauntHobby tgi = new ResturauntHobby(id, "TGI Friday", "Birmingham UK", "JD Wings", 55);
		ResturauntHobby newValues = new ResturauntHobby(null, "TGI Friday", "Southampton UK", "Veggie Pizza", 90);
		ResturauntHobby updatedTgi = new ResturauntHobby(id, newValues.getRestaurantName(), 
				newValues.getLocation(), newValues.getDish(), newValues.getRating()); 
		
		Optional<ResturauntHobby> optTgi = Optional.of(tgi);
		assertThat(optTgi.isPresent()); 
		
		Mockito.when(this.repo.findById(id)).thenReturn(optTgi);
        Mockito.when(this.repo.save(updatedTgi)).thenReturn(updatedTgi);
        
        assertThat(this.service.update(id, newValues)).isEqualTo(updatedTgi);
        
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).save(updatedTgi);
        
	}
 
}
