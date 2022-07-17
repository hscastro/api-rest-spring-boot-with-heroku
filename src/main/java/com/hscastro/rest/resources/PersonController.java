package com.hscastro.rest.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class PersonController {

	@GetMapping("/hello")
	public ResponseEntity<String> getString(){
		return ResponseEntity.ok("Olá mundo");
	}
}
