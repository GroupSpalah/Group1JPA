package org.com.lessons;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
}

class TestJpa {
    public static void main(String[] args) {
        Country ukraine = Country
                .builder()
                .name("Ukraine")
                .build();

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(ukraine);

        transaction.commit();

    }
}

/**
 * 1 2 3 4
 */
