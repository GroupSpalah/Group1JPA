package org.com.lessons;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

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

    @Column(name = "first_name", length = 50)
    String firstName;//first_name -sql, firstName

    String name;

    @Enumerated(EnumType.STRING)
    Region region;

    LocalDate date;
}

class TestJpa {
    public static void main(String[] args) {
        Country ukraine = Country
                .builder()
                .name("Canada")
                .date(LocalDate.now())
                .region(Region.KHARKIV)
                .firstName("Canada")
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
