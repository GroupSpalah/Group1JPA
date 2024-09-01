package org.com.lessons.relationships.many_to_one;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_id")
    int id;

    BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "FK_Ad_Person")
    Person person;
}

/**
 * Person(List<Email>)
 * Person(emails empty) ->
 */

