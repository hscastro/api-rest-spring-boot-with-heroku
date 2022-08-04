package com.hscastro.rest.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
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
	
	private static final String CELULAR = "9 99999990";

	private static final String RG = "88888888880";

	private static final String CPF = "99999999990";

	private static final long ID = 1L;

	private static final String FIRST_NAME_TEST0 = "First Name Test0";

	MockPerson input;
	
	@InjectMocks
	private PersonServiceImpl personService; 
	
	@Mock
	private PersonReposiory repository;
	
	private Person person;

	
	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockPerson();
		person = new Person(ID, FIRST_NAME_TEST0, CPF, RG, CPF, CELULAR, null);
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testWhenFindById() {
		Person person = input.mockEntity();
		person.setId(1L);
		
		Mockito.when(repository.findById(1L)).thenReturn(Optional.of(person));
		
		Person response = personService.findById(1L).get();
		assertNotNull(response);
		assertEquals(ID, response.getId());
		assertEquals(FIRST_NAME_TEST0, response.getName());
		assertEquals(CPF, response.getCpf());
		assertEquals(RG, response.getRg());
		assertEquals(CELULAR, response.getCelular());
		assertNotNull(response);		
	}
	
	@Test
	void wenFindAllThenReturnAnListOfPersons() {
		Mockito.when(repository.findAll()).thenReturn(List.of(person));
		
		List<Person> response = personService.findAll();
		
		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(Person.class, response.get(0).getClass());
		
		assertEquals(ID, response.get(0).getId());
		assertEquals(FIRST_NAME_TEST0, response.get(0).getName());
		assertEquals(CPF, response.get(0).getCpf());
		assertEquals(RG, response.get(0).getRg());				
		assertEquals(CELULAR, response.get(0).getCelular());
	}

}
