package org.com.lessons.relationships.one_to_many.uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;
import org.com.lessons.relationships.one_to_one.bi.ManBi;
import org.com.lessons.relationships.one_to_one.bi.PhoneBi;

import java.util.List;

class TestOneToManyUni {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        Leaf leaf1 = Leaf
                .builder()
                .color("Green1")
                .build();

        Leaf leaf2 = Leaf
                .builder()
                .color("Green2")
                .build();

        Tree tree = Tree
                .builder()
                .leaves(List.of(leaf1, leaf2))
                .size(10)
                .build();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(tree);

        transaction.commit();

    }
}

/**
 * 1 2 3 4
 */
