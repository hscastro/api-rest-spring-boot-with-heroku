package com.hscastro.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.hscastro.rest.domain.Person;
import com.hscastro.rest.dto.PersonDTO;
import com.hscastro.rest.services.MockPerson;

class MapperConverterTest {
	
	MockPerson mockPerson;
	
	ModelMapper mapper;
	

	@BeforeEach
	void setUp() throws Exception {
	  mockPerson = new MockPerson();
	  mapper = new ModelMapper();
	}

	@Test
	void parseEntityToDTOtest() {
		PersonDTO personDTO = mapper.map(mockPerson.mockEntity(), PersonDTO.class);
		assertEquals(Long.valueOf(0L), personDTO.getId());
		assertEquals("First Name Test0", personDTO.getName());
		assertEquals("99999999990", personDTO.getCpf());
		assertEquals("88888888880", personDTO.getRg());
		assertEquals("9 99999990", personDTO.getCelular());	
		assertEquals("Masculino0", personDTO.getSexo());			
	}

	@Test
	void parseDTOToEntitytest() {
		Person person = mapper.map(mockPerson.mockDTO(), Person.class);
		assertEquals(Long.valueOf(0L), person.getId());
		assertEquals("First Name Test0", person.getName());
		assertEquals("99999999990", person.getCpf());
		assertEquals("88888888880", person.getRg());
		assertEquals("9 99999990", person.getCelular());	
		assertEquals("Masculino0", person.getSexo());			
	}
}
