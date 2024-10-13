package org.com.lessons.inheritance.mapped_super_class;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;
import org.com.lessons.orp_rem.one_to_many.OrListChild;
import org.com.lessons.orp_rem.one_to_many.OrListParent;

import java.util.List;

class TestMSC {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        ChildMSC1 msc1 = ChildMSC1
                .builder()
                .model("X5")
                .age(15)
                .name("John")
                .build();

        ChildMSC2 msc2 = ChildMSC2
                .builder()
                .isAge(true)
                .age(25)
                .name("Jack")
                .build();

        em.persist(msc1);
        em.persist(msc2);

        transaction.commit();

    }
}

/**
 * 1) Saving Person - service Person
 * 2) Find Person by id - service Person
 * 3) Set person into ad - psvm
 * 4) Saving ad - service Ad
 */
