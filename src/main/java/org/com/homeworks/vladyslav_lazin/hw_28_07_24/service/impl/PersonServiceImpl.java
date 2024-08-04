package org.com.homeworks.vladyslav_lazin.hw_28_07_24.service.impl;

import java.util.List;

import org.com.homeworks.vladyslav_lazin.hw_28_07_24.dao.PersonDao;
import org.com.homeworks.vladyslav_lazin.hw_28_07_24.dao.impl.PersonDaoImpl;
import org.com.homeworks.vladyslav_lazin.hw_28_07_24.domain.Person;
import org.com.homeworks.vladyslav_lazin.hw_28_07_24.service.PersonService;

import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonServiceImpl implements PersonService{

    PersonDao personDao;

    public PersonServiceImpl() {
        personDao = new PersonDaoImpl();
    }
    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public Person findById(int id) {
        return personDao.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public void deleteById(int id) {
        personDao.deleteById(id);
    }

    @Override
    public void update(Person person, int id) {
        personDao.update(person, id);
    }

}
