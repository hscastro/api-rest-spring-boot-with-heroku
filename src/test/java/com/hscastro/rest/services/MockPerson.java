package com.hscastro.rest.services;

import java.util.ArrayList;
import java.util.List;

import com.hscastro.rest.domain.Person;
import com.hscastro.rest.dto.PersonDTO;

public class MockPerson {
	
	public Person mockEntity() {
		return mockEntity(0L);
	}
	
	public PersonDTO mockDTO() {
		return mockDTO(0L);
	}
	
	public Person mockEntity(Long id) {
		Person person = new Person();
		person.setId(id);
		person.setName("First Name Test"+id);
		person.setCpf("9999999999"+id);
		person.setRg("8888888888"+id);
		person.setCelular("9 9999999"+id);			
		person.setSexo(((id%2 == 0) ? "Masculino":" Feminino")+id);				
		return person;
	}

	public PersonDTO mockDTO(Long id) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(id);
		personDTO.setName("First Name Test"+id);
		personDTO.setCpf("9999999999"+id);
		personDTO.setRg("8888888888"+id);
		personDTO.setCelular("9 9999999"+id);		
		personDTO.setSexo(((id%2 == 0) ? "Masculino":" Feminino")+id);		
		return personDTO;
	}
	
	public List<Person> mockLista() {
		List<Person> persons = new ArrayList<>();
		
		for (int i = 0; i < 12; i++) {
			persons.add(mockEntity(Long.valueOf(i)));			
		}
		return persons;
	}
	
	public List<PersonDTO> mockDTOLista() {
		List<PersonDTO> personsDTO = new ArrayList<>();
		
		for (int i = 0; i < 12; i++) {
			personsDTO.add(mockDTO(Long.valueOf(i)));			
		}
		return personsDTO;
	}

}
