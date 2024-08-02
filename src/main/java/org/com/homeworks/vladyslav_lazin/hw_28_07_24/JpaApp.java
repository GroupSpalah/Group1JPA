package org.com.homeworks.vladyslav_lazin.hw_28_07_24;

import java.time.LocalDate;

import org.com.homeworks.vladyslav_lazin.hw_28_07_24.dao.impl.PersonDaoImpl;
import org.com.homeworks.vladyslav_lazin.hw_28_07_24.domain.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaApp {
    public static void main(String[] args) {
        // Person person = Person
        //                 .builder()
        //                 .name("John")
        //                 .surname("Doe")
        //                 .birthDate(LocalDate.of(1997,12, 13))
        //                 .build();
        PersonDaoImpl personDaoImpl = new PersonDaoImpl();
        // personDaoImpl.save(person);
        System.out.println(personDaoImpl.findById(1));
        }
}
