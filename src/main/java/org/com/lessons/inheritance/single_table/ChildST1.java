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
@DiscriminatorValue(value = "child_jt1")
public class ChildST1 extends ParentST {

    String model;
}
