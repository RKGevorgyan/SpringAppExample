package ru.stc.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.stc.springbootdemo.dao.PersonRepository;
import ru.stc.springbootdemo.dao.StudentRepository;
import ru.stc.springbootdemo.model.Person;
import ru.stc.springbootdemo.model.dto.PersonDto;
import ru.stc.springbootdemo.model.dto.mapper.PersonMapper;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    StudentRepository studentRepository;


    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public PersonDto findById(Long id) {
        Optional<Person> byId = personRepository.findById(id);
        Person person = byId.orElseGet(Person::new);
        PersonDto personDto = PersonMapper.MAPPER.toPersonDto(person);
        return personDto;
    }

    @Transactional
    public Person savePerson(@Valid PersonDto personDTO) {
        Person person = PersonMapper.MAPPER.toPerson(personDTO);
        return personRepository.save(person);
    }

    public List<Person> findPersonByName(@NotBlank String name) {
        return personRepository.findByName(name);
    }
}
