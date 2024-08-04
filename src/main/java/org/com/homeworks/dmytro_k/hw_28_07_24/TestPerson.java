package org.com.homeworks.dmytro_k.hw_28_07_24;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;

public class TestPerson {
    public static void main(String[] args) {

        Person John = Person
                .builder()
                .firstName("John")
                .lastName("Doe")
                .build();

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-person");

        @Cleanup
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        //entityManager.persist(John);

        Person person = entityManager.find(Person.class, 1);

        System.out.println(person);

        transaction.commit();
    }
}
