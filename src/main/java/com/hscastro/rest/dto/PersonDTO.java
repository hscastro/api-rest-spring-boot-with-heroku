package com.hscastro.rest.dto;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.hscastro.rest.domain.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

	private Long id;	
	private String name;	
	private String cpf;
	private String rg;	
	private String sexo;	
	private String celular;	
	private LocalDate dateNascimento;
	
	private static ModelMapper mapper = new ModelMapper();
	
	public static Person DTOtoPerson(PersonDTO personDTO) {
		return mapper.map(personDTO, Person.class);
	}
}
