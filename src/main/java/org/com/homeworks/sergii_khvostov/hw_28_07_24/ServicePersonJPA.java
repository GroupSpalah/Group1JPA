package org.com.homeworks.sergii_khvostov.hw_28_07_24;

import jakarta.persistence.*;
import lombok.Cleanup;


public class ServicePersonJPA {
    public static void main(String[] args) {
        PersonJPA personJPA = PersonJPA.builder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .build();

        @Cleanup
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("test-serega");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(personJPA);

        transaction.commit();
    }
}
