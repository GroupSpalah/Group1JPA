package org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa;

import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.dao_laptop.DAOLaptop;
import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.domen.LaptopJPA;

import java.time.LocalDate;

public class LaptopService {
    public static void main(String[] args) {
        DAOLaptop dl = new DAOLaptop();

        LaptopJPA laptopJPA = LaptopJPA
                .builder()
                .model("TUF15")
//                .id(102)
                .manufacturer("ASUS")
                .ramSize(32)
                .releaseDate(LocalDate.of(2021,12, 05))
                .ssdCapacity(1024)
                .processor("INTEL CORE I7")
                .build();

        /*LaptopJPA laptopJPA = LaptopJPA
                .builder()
                .model("TUF15")
                .manufacturer("ASUS")
                .ramSize(32)
                .releaseDate(LocalDate.of(2021,12, 05))
                .ssdCapacity(1024)
                .processor("INTEL CORE I7")
                .build();

        dl.add(laptopJPA);*/

        //dl.getById(1);
        //dl.getAll();
        //dl.deleteById(1);
        //dl.deleteAll();
        //dl.getByModel("TUF15");
        //dl.getByReleaseDate(LocalDate.of(2021,12,05));
        //dl.getByRAMAndSSD(32, 1024);
        //dl.getByProcessor("INTEL CORE I7");
        //dl.deleteByProcessor("INTEL CORE I7");
        //dl.deleteByRAMAndSSD(32, 1024);
    }
}
