package com.hscastro.rest.services;

import java.util.List;
import java.util.Optional;

import com.hscastro.rest.domain.Person;

public interface PersonService {

	Person save(Person p);
	Person update(Long id, Person p);
	Optional<Person> findById(Long id);
	List<Person> findAll();
}
