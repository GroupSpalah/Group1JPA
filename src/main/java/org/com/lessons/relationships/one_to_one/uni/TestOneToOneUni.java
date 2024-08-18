package org.com.lessons.relationships.one_to_one.uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;
import org.com.lessons.Country;
import org.com.lessons.Region;

import java.time.LocalDate;

class TestOneToOneUni {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        Phone phone = Phone
                .builder()
                .number("067")
                .build();

        Man john = Man
                .builder()
                .age(32)
                .phone(phone)
                .name("John")
                .build();


        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(john);
//        em.persist(phone);

        transaction.commit();

    }
}

/**
 * 1 2 3 4
 */
