package org.com.lessons;

import jakarta.persistence.*;
import lombok.Cleanup;

class DeleteObject {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

       /* Country country = em.find(Country.class, 2);

        em.remove(country);*/

//        Query query = em.createQuery("DELETE FROM Country c WHERE c.id =: c_id");
        Query query = em.createQuery("DELETE FROM Country c WHERE c.firstName =: c_name");

        query.setParameter("c_id", 52);

        query.executeUpdate();

        transaction.commit();

    }
}

/**
 * 1 2 3 4
 *
 *
 */
