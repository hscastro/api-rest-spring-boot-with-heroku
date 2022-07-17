package com.hscastro.rest.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hscastro.rest.domain.Person;
import com.hscastro.rest.services.PersonService;

@RestController
@RequestMapping("api/v1")
public class PersonController {
	
	private PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping("/hello")
	public ResponseEntity<String> getString(){
		return ResponseEntity.ok("Olá mundo");
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.POST,
			produces = "application/json", consumes = "application/json")
	public ResponseEntity<Person> create(@RequestBody Person person){
		Person person_ = personService.save(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(person_);
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET,
			produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<Person>> getAll(){
		List<Person> listPersons = personService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(listPersons);
	}
	
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.GET,
			produces = "application/json", consumes = "application/json")
	public ResponseEntity<Person> getById(@PathVariable Long id){
		Person person = personService.findById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(person);
	}
	
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.PUT,
			produces = "application/json", consumes = "application/json")
	public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person p){
		Person person = personService.update(id, p);
		return ResponseEntity.status(HttpStatus.OK).body(person);
	}
}
