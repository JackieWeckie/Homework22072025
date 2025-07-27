package com.homework22072025.Enteties;

import com.homework22072025.Type.WorkerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employeeType")
    @Enumerated(EnumType.STRING)
    private WorkerType workerType;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    public Person() {}

    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Person(WorkerType workerType, String name, String surname, String email, Integer age) {
        this.workerType = workerType;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }
}
