package com.hscastro.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hscastro.rest.domain.Person;
import com.hscastro.rest.repositories.PersonReposiory;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonReposiory personReposiory;

	
	public PersonServiceImpl(PersonReposiory personReposiory) {
		this.personReposiory = personReposiory;
	}

	@Override
	public Person save(Person person) {
		if(person != null) {
			return personReposiory.save(person);
		}
		throw new IllegalArgumentException("Objeto nullo, sem dados");
	}

	@Override
	public Person update(Long id, Person p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Person> findById(Long id) {
		Optional<Person> person = personReposiory.findById(id);
		if(person.isPresent()) {
			return person;
		}
		throw new IllegalArgumentException("Person não encontrado");
	}

	@Override
	public List<Person> findAll() {
		return personReposiory.findAll();
	}

}
