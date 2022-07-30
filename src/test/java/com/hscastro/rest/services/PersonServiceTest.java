package com.hscastro.rest.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hscastro.rest.domain.Person;
import com.hscastro.rest.repositories.PersonReposiory;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
	
	MockPerson input;
	
	@InjectMocks
	private PersonServiceImpl personService; 
	
	@Mock
	private PersonReposiory repository;

	
	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockPerson();
		MockitoAnnotations.openMocks(this);
	}
	

	@Test
	void testFindById() {
		Person person = input.mockEntity();
		person.setId(1L);
		
		Mockito.when(repository.findById(1L)).thenReturn(Optional.of(person));
		
		Person response = personService.findById(1L).get();
		assertNotNull(response);
		assertEquals(1L, response.getId());
		assertEquals("First Name Test0", response.getName());
		assertEquals("99999999990", response.getCpf());
		assertEquals("88888888880", response.getRg());
		assertEquals("9 99999990", response.getCelular());
		assertNotNull(response);		
	}

}
