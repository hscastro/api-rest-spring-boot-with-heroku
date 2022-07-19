package com.hscastro.rest.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

	private Long id;	
	private String name;	
	private String cpf;
	private String rg;	
	private String sexo;	
	private String raca;
	private String celular;	
	private LocalDate dateNascimento;
}
