package org.com.homeworks.vladyslav_lazin.hw_28_07_24.dao.impl;

import org.com.homeworks.vladyslav_lazin.hw_28_07_24.dao.PersonDao;
import org.com.homeworks.vladyslav_lazin.hw_28_07_24.domain.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonDaoImpl implements PersonDao {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("vlazin-jpa");

        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public void save(Person person) {
        transaction.begin();
        entityManager.persist(person);
        transaction.commit();
    }

    @Override
    public Person findById(int id) {
        transaction.begin();
        Person person = entityManager.find(Person.class, 1);
        transaction.commit();
        return person;
    }

}
