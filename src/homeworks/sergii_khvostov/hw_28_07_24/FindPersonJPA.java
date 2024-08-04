package homeworks.sergii_khvostov.hw_28_07_24;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;


public class FindPersonJPA {
    public static void main(String[] args) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        PersonJPA personJPA = em.find(PersonJPA.class, 1);

        System.out.println(personJPA);

        transaction.commit();
    }
}
