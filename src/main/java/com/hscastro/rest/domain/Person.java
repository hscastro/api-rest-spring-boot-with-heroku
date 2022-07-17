package com.hscastro.rest.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person implements Serializable {	

	private static final long serialVersionUID = -8893125754426529264L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 200)
	private String name;
	
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "rg", nullable = false, length = 11)
	private String rg;
	
	@Column(name = "sexo", nullable = true, length = 20)
	private String sexo;
	
	@Column(name = "raca", nullable = false, length = 50)
	private String raca;
	
	@Column(name = "celular", nullable = false, length = 20)
	private String celular;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dateNascimento", nullable = false, length = 20)
	private LocalDate dateNascimento;
	
}
