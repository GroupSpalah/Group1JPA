package org.com.lessons.relationships.one_to_one.bi;

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
public class ManBi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manbi_id")
    int id;

    String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "manBi")
    PhoneBi phoneBi;
}
