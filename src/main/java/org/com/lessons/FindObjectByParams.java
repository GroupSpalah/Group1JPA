package org.com.lessons;

import jakarta.persistence.*;
import lombok.Cleanup;

class FindObjectByParams {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<Country> query = em.createQuery("FROM Country c WHERE c.region =:r_name", Country.class);

        query.setParameter("r_name", Region.DNIPRO);

        Country canada = query.getSingleResult();

        System.out.println(canada);


        transaction.commit();

    }
}


