package ru.stc.springbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stc.springbootdemo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
