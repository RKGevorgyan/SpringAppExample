package ru.stc.springbootdemo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "last_name")
    private String lastName;
    private String subject;
    @ManyToMany
    @JoinTable(
            name = "study",
            joinColumns = @JoinColumn(name = "lectors_id"),
            inverseJoinColumns = @JoinColumn(name = "students_id")
    )
    private List<Student> students;

    public Lector(String lastName, String subject) {
        this.lastName = lastName;
        this.subject = subject;
    }

    public Lector() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Lector {" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", subject='" + subject + '\'' +
                ", students=" + students +
                '}';
    }

}
