package org.com.homeworks.dmytro_k.hw_04_08_24.service.impl;

import org.com.homeworks.dmytro_k.hw_04_08_24.dao.LaptopDao;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.impl.LaptopDaoImpl;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.Laptop;
import org.com.homeworks.dmytro_k.hw_04_08_24.service.LaptopService;

import java.time.LocalDate;

public class LaptopServiceImpl implements LaptopService {

    private final LaptopDao laptopDao = new LaptopDaoImpl();

    public void addLaptop(Laptop laptop) {
        laptopDao.addLaptop(laptop);
    }

    public Laptop findById(int id) {
        return laptopDao.findById(id);
    }

    public void printAllLaptop() {
        laptopDao.printAllLaptop();
    }

    public void filterByReleaseDate(LocalDate date) {
        laptopDao.filterByReleaseDate(date);
    }

    public void filterByTwoParam(String inputQuery, String firstParam, String secondParam,
                                 int firstValue, int secondValue) {
        laptopDao.filterByTwoParam(inputQuery, firstParam, secondParam, firstValue, secondValue);
    }

    public void filterByModel(String param, String value) {
        laptopDao.filterByModel(param, value);
    }

    public void filerByProcessor(String param, String value) {
        laptopDao.filerByProcessor(param, value);
    }

    public void deleteByProcessor(String value) {
        laptopDao.deleteByProcessor(value);
    }

    public void deleteByRamAndSsd(int firstParam, int secondParam) {
        laptopDao.deleteByRamAndSsd(firstParam, secondParam);
    }

    public void update(Laptop laptop) {
        laptopDao.update(laptop);
    }
}
