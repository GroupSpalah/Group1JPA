package org.com.homeworks.vladyslav_lazin.hw_28_07_24.service;

import java.util.List;

import org.com.homeworks.vladyslav_lazin.hw_28_07_24.domain.Person;

public interface PersonService {
    void save(Person person);

    Person findById(int id);

    List<Person> findAll();

    void deleteById(int id);

    void update(Person person, int id);

}
