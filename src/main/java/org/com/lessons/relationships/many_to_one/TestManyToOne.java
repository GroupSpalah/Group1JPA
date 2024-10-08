package org.com.lessons.relationships.many_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;
import org.com.lessons.orp_rem.one_to_one.OrChild;
import org.com.lessons.orp_rem.one_to_one.OrParent;

import java.math.BigDecimal;

class TestManyToOne {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        Person john = Person
                .builder()
                .name("John")
                .build();

        transaction.begin();

//        em.persist(john);

        Person person = em.find(Person.class, 1);

        Ad ad = Ad
                .builder()
                .price(BigDecimal.valueOf(12.45))
                .person(person)
                .build();

//        em.persist(ad);

        OrChild child = OrChild
                .builder()
                .age(10)
                .build();

        OrParent parent = OrParent
                .builder()
                .name("John")
                .child(child)
                .build();

//        em.persist(parent);

        OrParent orParent = em.find(OrParent.class, 1);

        orParent.setChild(null);

        transaction.commit();

    }
}

/**
 * 1) Saving Person - service Person
 * 2) Find Person by id - service Person
 * 3) Set person into ad - psvm
 * 4) Saving ad - service Ad
 */
