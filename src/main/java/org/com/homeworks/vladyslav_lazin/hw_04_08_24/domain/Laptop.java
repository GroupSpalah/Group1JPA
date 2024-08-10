package org.com.homeworks.vladyslav_lazin.hw_04_08_24.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "laptops")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Laptop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "laptop_id")
    int id;

    String model;

    String manufacturer;

    @Column(name = "prod_date")
    LocalDate prodDate;

    @Column(name = "ram_capacity")
    int ramCapacity;

    @Column(name = "ssd_capacity")
    int ssdCapacity;
    
    @Column(name = "cpu_name")
    String cpuName;


}
