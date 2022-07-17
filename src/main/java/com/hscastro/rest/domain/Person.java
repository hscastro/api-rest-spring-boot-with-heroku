package com.hscastro.rest.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	private Long id;
	private String name;
	private String cpf;
	private String rg;
	private String sexo;
	private String raca;
	private String celular;
	private LocalDate dateNascimento;
	
}
