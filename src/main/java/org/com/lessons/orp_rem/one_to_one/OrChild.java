package org.com.lessons.orp_rem.one_to_one;

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
public class OrChild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "child_id")
    int id;

    int age;
}
