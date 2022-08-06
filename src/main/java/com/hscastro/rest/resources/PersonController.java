package com.hscastro.rest.resources;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hscastro.rest.domain.Person;
import com.hscastro.rest.dto.PersonDTO;
import com.hscastro.rest.services.PersonService;

@RestController
@RequestMapping("api/v1")
public class PersonController {
	
	
	private PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ResponseEntity<String> getHealth(){
		return ResponseEntity.ok("UP: "+LocalDateTime.now());
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> create(@RequestBody PersonDTO personDTO){
		Person person_ = personService.save(personDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(person_);
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> getAll(){
		List<Person> listPersons = personService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(listPersons);
	}
	
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getById(@PathVariable Long id){
		Person person = personService.findById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(person);
	}
	
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody PersonDTO personDTO){
		Person person = personService.update(id, personDTO);
		return ResponseEntity.status(HttpStatus.OK).body(person);
	}
	
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable Long id){
		personService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
	}
}
