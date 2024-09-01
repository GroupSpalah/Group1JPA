package org.com.homeworks.dmytro_k.hw_04_08_24.service;

import org.com.homeworks.dmytro_k.hw_04_08_24.domain.Laptop;

import java.time.LocalDate;

public interface LaptopService {

    void addLaptop(Laptop laptop);

    Laptop findById(int id);

    void printAllLaptop();

    void filterByReleaseDate(LocalDate date);

    void filterByTwoParam(String inputQuery, String firstParam, String secondParam,
                          int firstValue, int secondValue);

    void filterByModel(String param, String value);

    void filerByProcessor(String param, String value);

    void deleteByProcessor(String value);

    void deleteByRamAndSsd(int firstParam, int secondParam);

    void update(Laptop laptop);
}
