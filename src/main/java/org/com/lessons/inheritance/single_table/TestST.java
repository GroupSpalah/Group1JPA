package org.com.lessons.inheritance.single_table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;

class TestST {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        ChildST1 st1 = ChildST1
                .builder()
                .age(23)
                .model("X5")
                .name("John")
                .build();

        ChildST2 st2 = ChildST2
                .builder()
                .name("Jack")
                .isAge(true)
                .age(25)
                .build();

        em.persist(st1);
        em.persist(st2);

        transaction.commit();

    }
}

/**
 * 1) Saving Person - service Person
 * 2) Find Person by id - service Person
 * 3) Set person into ad - psvm
 * 4) Saving ad - service Ad
 */
