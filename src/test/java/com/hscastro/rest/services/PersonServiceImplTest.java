package com.hscastro.rest.services;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.hscastro.rest.domain.Person;
import com.hscastro.rest.dto.PersonDTO;
import com.hscastro.rest.repositories.PersonReposiory;

public class PersonServiceImplTest {

	private static final String CELULAR = "982726262";

	private static final String RACA = "parda";

	private static final String SEXO = "Masculino";

	private static final String RG = "78292839291";

	private static final String CPF = "287392010191";

	private static final String NAME = "Antonio";

	private static final long ID = 1L;

	@InjectMocks
	private PersonServiceImpl personServiceImpl; 
	
	@Mock
	private PersonReposiory personRepository;
	
	@Mock
	private Person person;
	
	@Mock
	private PersonDTO personDTO;
	
	@Mock
	private Optional<Person> optionalPersons;
	
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		initPersons();
	}

	
	@Test
	void wenFindByIdThenReturnAnUserInstance() {
		Mockito.when(personRepository.findById(Mockito.anyLong())).thenReturn(optionalPersons);
		
		Person response = personServiceImpl.findById(ID).get();
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(Person.class, response.getClass());
		Assertions.assertNotEquals(ID, response.getId());		
	}
	
	private void initPersons() {
		LocalDate localDate       = LocalDate.of(1985, 07, 25);
		Person person = new Person(ID, NAME, CPF,RG, SEXO, RACA,CELULAR, localDate);
		PersonDTO personDTO = new PersonDTO(ID, NAME, CPF,RG, SEXO, RACA,CELULAR, localDate);
		optionalPersons = Optional.of(new Person(ID, NAME, CPF,RG, SEXO, RACA,CELULAR, localDate));		
		
	}
}
