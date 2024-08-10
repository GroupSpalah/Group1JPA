package org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.service;

import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.domen.LaptopJPA;

import java.time.LocalDate;
import java.util.List;

public interface LaptopJPAService {

    void addLaptop(LaptopJPA laptop);

    LaptopJPA getLaptopById(int id);

    List<LaptopJPA> getAllLaptops();

    void deleteLaptopByID(int id);

    void deleteAllLaptops();

    void updateLaptop(int id, LaptopJPA newLaptop);

    List<LaptopJPA> getLaptopByModel(String model);

    List<LaptopJPA> getLaptopByReleaseDate(LocalDate releaseDate);

    List<LaptopJPA> getLaptopByRAMAndSSD(int ramSize, int ssdCapacity);

    List<LaptopJPA> getLaptopByProcessor(String processor);

    void deleteLaptopByProcessor(String processor);

    void deleteLaptopByRAMAndSSD(int ramSize, int ssdCapacity);
}
