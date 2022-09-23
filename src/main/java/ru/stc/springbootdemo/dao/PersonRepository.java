package ru.stc.springbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.stc.springbootdemo.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameAndAge(String name, Integer age);

    @Query(value = "select count(*) from persons", nativeQuery = true)
    List<Person> getCountRows();

}
