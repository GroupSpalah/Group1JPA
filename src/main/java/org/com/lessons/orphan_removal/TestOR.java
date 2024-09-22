package org.com.lessons.orphan_removal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;

class TestOR {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        OrChild child = OrChild
                .builder()
                .age(10)
                .build();

        OrParent parent = OrParent
                .builder()
                .name("John")
                .child(child)
                .build();

        em.persist(parent);

        transaction.commit();

    }
}

