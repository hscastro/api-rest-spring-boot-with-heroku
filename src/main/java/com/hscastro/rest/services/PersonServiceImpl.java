package com.hscastro.rest.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.hscastro.rest.domain.Person;
import com.hscastro.rest.dto.PersonDTO;
import com.hscastro.rest.exceptions.ObjectNotFoundException;
import com.hscastro.rest.repositories.PersonReposiory;

@Service
public class PersonServiceImpl implements PersonService {    
	
	private PersonReposiory personReposiory;
			
	private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	public PersonServiceImpl(PersonReposiory personReposiory) {
		this.personReposiory = personReposiory;
		logger.info("Starting application");
	}

	@Override
	public Person save(PersonDTO personDTO) {
		if(personDTO != null) {
			Person person_ = personReposiory.save(PersonDTO.DTOtoPerson(personDTO));
			logger.info("Saving one Person na base de dados - ", person_);
			return person_;			
		}	
		ObjectNotFoundException exception = new ObjectNotFoundException("O objeto person está nulo");
		logger.info("Exception - ", exception.getMessage());
		throw exception;
	}

	@Override
	public Optional<Person> findById(Long id) {
		Optional<Person> person = personReposiory.findById(id);
		logger.info("Finding one Person by Id - ", person);
		if(person.isPresent()) {
			logger.info("Finding one Person by Id - ", person);
			return person;
		}
		ObjectNotFoundException exception = new ObjectNotFoundException("Person não encontrado");
		logger.info("Exception - ", exception.getMessage());
		throw exception;
	}

	@Override
	public List<Person> findAll() {
		List<Person> list = personReposiory.findAll();
		logger.info("Returning the list of Persons - ", list);
		return list;
	}
	
	@Override
	public Person update(Long id, PersonDTO personDTO) {
		Person person_ = personReposiory.findById(id).get();
		logger.info("Finding one Person by Id for update - ", person_);
		if(person_ != null) {
			Person per = PersonDTO.DTOtoPerson(personDTO);
			person_.setName(per.getName());
			person_.setCpf(per.getCpf());
			person_.setRg(per.getRg());
			person_.setSexo(per.getSexo());
			person_.setCelular(per.getCelular());
			person_.setDateNascimento(per.getDateNascimento());	
			personReposiory.save(person_);
			logger.info("Update the dados of Person by Id - ", person_);
			return person_;
		}
		ObjectNotFoundException exception = new ObjectNotFoundException("Person não pode ser atualizado");
		logger.info("Exception - ", exception.getMessage());
		throw exception;
	}
	
	public void delete(Long id) {
		Optional<Person> person = personReposiory.findById(id);	
		logger.info("Finding one Person by Id for delete - ", person);
		if(person.isPresent()) {
			personReposiory.deleteById(id);
			logger.info("Person delete with success");
		}		
	}
}
