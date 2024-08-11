package org.com.homeworks.dmytro_k.hw_04_08_24.dao;

import org.com.homeworks.dmytro_k.hw_04_08_24.domain.Laptop;

public interface LaptopDao {
    void addLaptop(Laptop laptop);

    Laptop findById(int id);

    void printAllLaptop();

    void filterByReleaseDate();

    void filterByTwoParam(String inputQuery, String firstParam, String secondParam,
                          int firstValue, int secondValue);

    void filterByModel(String param, String value);

    void filerByProcessor(String param, String value);

    void deleteByProcessor(String value);

    void deleteByRamAndSsd(int firstParam, int secondParam);
}