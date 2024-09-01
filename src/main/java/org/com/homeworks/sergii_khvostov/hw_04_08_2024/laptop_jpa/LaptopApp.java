package org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa;

import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.domain.LaptopJPA;
import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.service.impl.LaptopJPAServiceImpl;

import java.time.LocalDate;

public class LaptopApp {
    public static void main(String[] args) {
        LaptopJPAServiceImpl ljsi = new LaptopJPAServiceImpl();

        LaptopJPA laptopJPA = LaptopJPA
                .builder()
                .model("TUF DASH 15")
                .id(102)
                .manufacturer("ASUS")
                .ramSize(32)
                .releaseDate(LocalDate.of(2021, 12, 05))
                .ssdCapacity(1024)
                .processor("INTEL CORE I7")
                .build();

        // ljsi.addLaptop(laptopJPA);

    }
}
