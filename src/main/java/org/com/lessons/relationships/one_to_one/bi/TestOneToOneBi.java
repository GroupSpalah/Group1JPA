package org.com.lessons.relationships.one_to_one.bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;

class TestOneToOneBi {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        PhoneBi phone = PhoneBi
                .builder()
                .name("067")
                .build();

        ManBi john = ManBi
                .builder()
                .phoneBi(phone)
                .name("John")
                .build();

        phone.setManBi(john);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

//        em.persist(john);
        ManBi manBi = em.find(ManBi.class, 1);

        transaction.commit();

    }
}

/**
 * 1 2 3 4
 */
