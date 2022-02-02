package com.dxc.personrestapi.controller;

import java.util.List;

import com.dxc.personrestapi.repository.PersonRepository;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
 public class PersonController<Person> {

  private PersonRepository repository;

  void PersonController(PersonRepository repository) {
    this.repository = repository;
  }

  
 
  @GetMapping("/person")
  List<Person> all() {
    return Repository.findAll();
  }

  
  @GetMapping("/person/{id}")
  Person one(@PathVariable Integer id) {
    
    return Repository.findById(id)
      .orElseThrow(()-> new PersonNotFoundException(id));
  }
  

  @PostMapping("/person")
  Person newPerson(@RequestBody Person newPerson) {
    return Repository.save(newPerson);
  }

 
  

  @PutMapping("/person/{id}")
  Person replacePerson(@RequestBody Person newPerson, @PathVariable Integer id) {
    
    return Repository.findById(id)
      .map(person -> {
        author.setName(newPerson.getName());
        author.setEmail(newPerson.getEmail());
        author.setDob(LocalDate.now());
        return repository.save(person);
      })
      .orElseGet(() -> {
        newPerson.setId(id);
        return repository.save(newPerson);
      });
  }

  @DeleteMapping("/person/{id}")
  void deletePerson(@PathVariable Integer id) {
    Repository.deleteById(id);
  }
}
