package org.com.homeworks.dmytro_k.hw_04_08_24.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dk_laptops")
public class Laptop {
    @Setter
    @Column(name = "laptop_id", length = 15)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Setter
    String model;
    @Setter
    String manufacturer;
    @Column(name = "release_date", length = 15)
    LocalDate releaseDate;
    @Column(name = "RAM_capacity", length = 15)
    int RAMCapacity;
    @Column(name = "SSD_capacity", length = 15)
    int SSDCapacity;
    String processor;

    @Override
    public String toString() {
        return
                "\n| id=" + id +
                        " | model='" + model + '\'' +
                        " | manufacturer='" + manufacturer + '\'' +
                        " | releaseDate='" + releaseDate + '\'' +
                        " | RAMCapacity=" + RAMCapacity +
                        " | SSDCapacity=" + SSDCapacity +
                        " | processor='" + processor + '\'' +
                        " |" +
                        "\n------------------------------------------------------------------------------------------------" +
                        "------------------------------------------------------------";
    }
}
