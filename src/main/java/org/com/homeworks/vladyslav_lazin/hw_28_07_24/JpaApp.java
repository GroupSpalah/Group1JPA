package org.com.homeworks.vladyslav_lazin.hw_28_07_24;

import java.time.LocalDate;

import org.com.homeworks.vladyslav_lazin.hw_28_07_24.domain.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaApp {
    public static void main(String[] args) {
        Person person = Person
                        .builder()
                        .name("Vasya")
                        .surname("Pupkin")
                        .birthDate(LocalDate.of(1999,1, 21))
                        .build();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vlazin-jpa");

        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(person);
        transaction.commit();
    }
}
