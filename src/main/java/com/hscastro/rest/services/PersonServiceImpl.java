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
	
	@Override
	public Person update(Long id, Person p) {
		Person person_ = personReposiory.findById(id).get();
		if(person_ != null) {
			person_.setName(p.getName());
			person_.setCpf(p.getCpf());
			person_.setRg(p.getRg());
			person_.setSexo(p.getSexo());
			person_.setRaca(p.getName());
			person_.setCelular(p.getCelular());
			person_.setDateNascimento(p.getDateNascimento());
			personReposiory.save(person_);
			return person_;
		}
		throw new IllegalArgumentException("Person não pode ser atualizado");
	}

}
