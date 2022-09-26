package ru.stc.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stc.springbootdemo.model.Person;
import ru.stc.springbootdemo.model.dto.PersonDto;
import ru.stc.springbootdemo.service.PersonService;

import java.util.List;

// .../person/...

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/all")
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonDto findPersonById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Person> findPersonByName(@PathVariable String name) {
        return personService.findPersonByName(name);
    }

    @PostMapping("/create")
    public Person createPerson(@RequestBody PersonDto person) {
        return personService.savePerson(person);
    }

}
