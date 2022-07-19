package com.hscastro.rest.services;

import java.util.List;
import java.util.Optional;

import com.hscastro.rest.domain.Person;
import com.hscastro.rest.dto.PersonDTO;

public interface PersonService {

	Person save(PersonDTO personDTO);
	Person update(Long id, PersonDTO personDTO);
	Optional<Person> findById(Long id);
	List<Person> findAll();
	void delete(Long id); 
}
