package org.com.lessons.inheritance.single_table;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "jt_type")
public abstract class ParentST {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pjt_id")
    int id;

    String name;
    int age;
}
