package org.com.lessons.relationships.one_to_one.uni;

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
public class Man {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "man_id")
    int id;

    String name;

    int age;

    @OneToOne(cascade = CascadeType.PERSIST)
    Phone phone;
}
