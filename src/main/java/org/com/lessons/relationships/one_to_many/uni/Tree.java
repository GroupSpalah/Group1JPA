package org.com.lessons.relationships.one_to_many.uni;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int size;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_Leaf_Tree")
    List<Leaf> leaves;
}
