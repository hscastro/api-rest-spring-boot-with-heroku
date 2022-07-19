package com.hscastro.rest.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hscastro.rest.domain.Person;
import com.hscastro.rest.dto.PersonDTO;
import com.hscastro.rest.exceptions.ObjectNotFoundException;
import com.hscastro.rest.repositories.PersonReposiory;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonReposiory personReposiory;
	
	@Autowired
	private ModelMapper mapper;

	
	public PersonServiceImpl(PersonReposiory personReposiory) {
		this.personReposiory = personReposiory;
	}

	@Override
	public Person save(PersonDTO personDTO) {
		if(personDTO != null) {
			return personReposiory.save(mapper.map(personDTO, Person.class));
		}	
		throw new ObjectNotFoundException("O objeto person está nulo");
	}

	@Override
	public Optional<Person> findById(Long id) {
		Optional<Person> person = personReposiory.findById(id);
		if(person.isPresent()) {
			return person;
		}
		throw new ObjectNotFoundException("Person não encontrado");
	}

	@Override
	public List<Person> findAll() {
		return personReposiory.findAll();
	}
	
	@Override
	public Person update(Long id, PersonDTO personDTO) {
		Person person_ = personReposiory.findById(id).get();
		if(person_ != null) {
			person_.setName(personDTO.getName());
			person_.setCpf(personDTO.getCpf());
			person_.setRg(personDTO.getRg());
			person_.setSexo(personDTO.getSexo());
			person_.setRaca(personDTO.getName());
			person_.setCelular(personDTO.getCelular());
			person_.setDateNascimento(personDTO.getDateNascimento());			
			return personReposiory.save(mapper.map(personDTO, Person.class));
		}
		throw new IllegalArgumentException("Person não pode ser atualizado");
	}
	
	public void delete(Long id) {
		Optional<Person> person = personReposiory.findById(id);	
		if(person.isPresent()) {
			personReposiory.deleteById(id);
		}		
	}

}
