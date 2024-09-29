package org.com.lessons.orp_rem.one_to_many;

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
public class OrListChild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orlc_id")
    int id;

    int age;
}
