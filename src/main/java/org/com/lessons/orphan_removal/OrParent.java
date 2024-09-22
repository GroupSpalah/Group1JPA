package org.com.lessons.orphan_removal;

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
public class OrParent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parent_id")
    int id;

    String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    OrChild child;
}
