package com.hscastro.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hscastro.rest.domain.Person;

@Repository
public interface PersonReposiory extends JpaRepository<Person, Long>{

}
