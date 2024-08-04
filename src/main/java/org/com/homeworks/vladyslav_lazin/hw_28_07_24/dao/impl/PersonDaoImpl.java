package org.com.homeworks.vladyslav_lazin.hw_28_07_24.dao.impl;

import java.util.List;


import org.com.homeworks.vladyslav_lazin.hw_28_07_24.dao.PersonDao;
import org.com.homeworks.vladyslav_lazin.hw_28_07_24.domain.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class PersonDaoImpl implements PersonDao {
    private final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("vlazin-jpa");

    @Override
    public void save(Person person) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(person);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public Person findById(int id) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Person person = entityManager.find(Person.class, 1);
        transaction.commit();
        entityManager.close();
        return person;
    }

    @Override
    public List<Person> findAll() {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        TypedQuery<Person> query = entityManager.createQuery("FROM Person p", Person.class);
        List<Person> persons = query.getResultList();
        transaction.commit();
        entityManager.close();
        return persons;
    }

    @Override
    public void deleteById(int id) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Person p WHERE p.id =: pId");
        query.setParameter("pId", id);
        query.executeUpdate();
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void update(Person person, int id) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        person.setId(id);
        transaction.begin();
        
        Person newPerson = entityManager.merge(person);
        entityManager.persist(newPerson);
        transaction.commit();
        entityManager.close();
    }

}
