package org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.domen;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class LaptopJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String model;

    String manufacturer;

    @Column(name = "release_date", length = 50)
    LocalDate releaseDate;

    String processor;

    @Column(name = "ram_size", length = 20)
    int ramSize;

    @Column(name = "ssd_capacity", length = 20)
    int ssdCapacity;

}
