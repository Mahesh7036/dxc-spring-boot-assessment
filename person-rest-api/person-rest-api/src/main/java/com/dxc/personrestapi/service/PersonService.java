package com.dxc.personrestapi.service;
import java.util.List;

import com.dxc.personrestapi.model.Person;

public interface PersonService {

    public Person getPersonById(int id);

    public Person getPersonByName(String Name);

    public Person createPerson(Person person);

    public Person updatePerson(Person person);

    public void deletePerson(int id);

    public List<Person> getAllPersons();

    
}