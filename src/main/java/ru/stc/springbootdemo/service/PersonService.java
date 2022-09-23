package ru.stc.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stc.springbootdemo.dao.PersonRepository;
import ru.stc.springbootdemo.model.Person;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        Optional<Person> byId = personRepository.findById(id);
        return byId.orElseGet(Person::new);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findPersonByName(String name) {
        return personRepository.findByName(name);
    }
}
