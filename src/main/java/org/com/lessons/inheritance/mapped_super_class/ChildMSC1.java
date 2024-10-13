package org.com.lessons.inheritance.mapped_super_class;
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
public class ChildMSC1 extends ParentMSC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "msc1_id")
    int id;

    String model;
}
