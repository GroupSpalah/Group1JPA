package org.com.homeworks.dmytro_k.hw_04_08_24.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.GenericLaptopDao;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.LaptopDAOFactory;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.Laptop;
import org.com.homeworks.dmytro_k.hw_04_08_24.service.LaptopService;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class MySQLLaptopServiceImpl implements LaptopService<Laptop, Integer> {

    LaptopDAOFactory LAPTOP_DAO_FACTORY_MY_SQL = LaptopDAOFactory.getInstance(1);
    GenericLaptopDao<Laptop, Integer> LAPTOP_DAO = LAPTOP_DAO_FACTORY_MY_SQL.getLaptopDao();

    public void addLaptop(Laptop laptop) {
        LAPTOP_DAO.addLaptop(laptop);
    }

    public Laptop findById(Integer id) {
        return LAPTOP_DAO.findById(id);
    }

    public void printAllLaptop() {
        LAPTOP_DAO.printAllLaptop();
    }

    public void filterByReleaseDate(LocalDate date) {
        LAPTOP_DAO.filterByReleaseDate(date);
    }

    public void filterByTwoParam(String firstParam, String secondParam,
                                 java.lang.Object firstValue, java.lang.Object secondValue) {
        LAPTOP_DAO.filterByTwoParam(firstParam, secondParam, firstValue, secondValue);
    }

    public void filterByModel(String value) {
        LAPTOP_DAO.filterByModel(value);
    }

    public void filerByProcessor(String value) {
        LAPTOP_DAO.filerByProcessor(value);
    }

    public void deleteByProcessor(String value) {
        LAPTOP_DAO.deleteByProcessor(value);
    }

    public void deleteByRamAndSsd(int firstParam, int secondParam) {
        LAPTOP_DAO.deleteByRamAndSsd(firstParam, secondParam);
    }

    public void update(Laptop laptop) {
        LAPTOP_DAO.update(laptop);
    }

    @Override
    public List<Laptop> getAllLaptop() {
        return LAPTOP_DAO.getAllLaptop();
    }
}
