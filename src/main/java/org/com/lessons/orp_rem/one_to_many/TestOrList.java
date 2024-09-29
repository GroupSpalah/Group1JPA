package org.com.lessons.orp_rem.one_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;

import java.util.List;

class TestOrList {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        OrListChild child1 = OrListChild
                .builder()
                .age(10)
                .build();

        OrListChild child2 = OrListChild
                .builder()
                .age(15)
                .build();

        OrListParent parent = OrListParent
                .builder()
                .list(List.of(child1, child2))
                .name("John")
                .build();

//        em.persist(parent);

        OrListParent parent1 = em.find(OrListParent.class, 2);

        List<OrListChild> list = parent1.getList();
        list.set(0, null);

        transaction.commit();

    }
}

/**
 * 1) Saving Person - service Person
 * 2) Find Person by id - service Person
 * 3) Set person into ad - psvm
 * 4) Saving ad - service Ad
 */
