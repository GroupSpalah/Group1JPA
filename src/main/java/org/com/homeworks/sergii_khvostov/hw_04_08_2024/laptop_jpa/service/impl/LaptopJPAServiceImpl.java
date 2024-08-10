package org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.dao_laptop.DAOLaptop;
import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.domen.LaptopJPA;
import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.service.LaptopJPAService;

import java.time.LocalDate;
import java.util.List;

//@FieldDefaults(level = AccessLevel.PRIVATE)

public record LaptopJPAServiceImpl(DAOLaptop daoLaptop) implements LaptopJPAService {

    @Override
    public void addLaptop(LaptopJPA laptop) {
        daoLaptop.add(laptop);

    }

    @Override
    public LaptopJPA getLaptopById(int id) {
        return daoLaptop.getById(id);
    }

    @Override
    public List<LaptopJPA> getAllLaptops() {
        return daoLaptop.getAll();
    }

    @Override
    public void deleteLaptopByID(int id) {
        daoLaptop.deleteById(id);

    }

    @Override
    public void deleteAllLaptops() {
        daoLaptop.deleteAll();

    }

    @Override
    public void updateLaptop(int id, LaptopJPA newLaptop) {
        daoLaptop.update(id, newLaptop);

    }

    @Override
    public List<LaptopJPA> getLaptopByModel(String model) {
        return daoLaptop.getByModel(model);
    }

    @Override
    public List<LaptopJPA> getLaptopByReleaseDate(LocalDate releaseDate) {
        return daoLaptop.getByReleaseDate(releaseDate);
    }

    @Override
    public List<LaptopJPA> getLaptopByRAMAndSSD(int ramSize, int ssdCapacity) {
        return daoLaptop.getByRAMAndSSD(ramSize, ssdCapacity);
    }

    @Override
    public List<LaptopJPA> getLaptopByProcessor(String processor) {
        return daoLaptop.getByProcessor(processor);
    }

    @Override
    public void deleteLaptopByProcessor(String processor) {
        daoLaptop.deleteByProcessor(processor);

    }

    @Override
    public void deleteLaptopByRAMAndSSD(int ramSize, int ssdCapacity) {
        daoLaptop.deleteByRAMAndSSD(ramSize, ssdCapacity);

    }
}
