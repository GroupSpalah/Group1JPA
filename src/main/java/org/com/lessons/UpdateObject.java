package org.com.lessons;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;

class UpdateObject {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Country country = em.find(Country.class, 102);

        update(country);

//        em.persist(country);//no need to do

        transaction.commit();

    }

    public static void update(Country country) {//id != 0
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em1 = factory.createEntityManager();

        EntityTransaction transaction = em1.getTransaction();

        transaction.begin();

        country.setName("Austria");

        Country country1 = em1.merge(country);

        em1.persist(country1);

        transaction.commit();
    }
}

/**
 * 1 2 3 4
 * getById -> Laptop(id != 0)
 * update(Laptop)
 *
 */
