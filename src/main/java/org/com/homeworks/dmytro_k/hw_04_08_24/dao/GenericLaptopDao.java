package org.com.homeworks.dmytro_k.hw_04_08_24.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

import static org.com.homeworks.dmytro_k.hw_04_08_24.util.ConstantsUtil.UNIT_NAME;

public interface GenericLaptopDao<T, ID> {

    EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(UNIT_NAME);

    void addLaptop(T laptop);

    T findById(ID id);

    void printAllLaptop();

    void filterByReleaseDate(LocalDate date);

    void filterByTwoParam(String firstParam, String secondParam,
                          Object firstValue, Object secondValue);

    void filterByModel(String value);

    void filerByProcessor(String value);

    void deleteByProcessor(String value);

    void deleteByRamAndSsd(int ram, int ssd);

    void update(T laptop);

    //для переноса таблицы
    List<T> getAllLaptop();
}