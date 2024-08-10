package org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.dao;

import java.time.LocalDate;
import java.util.List;

public interface DAO<T> {

    void add(T entity);

    T getById(int id);

    List<T> getAll();

    void deleteById(int id);

    void deleteAll();

    void update(int id, T entity);

    List<T> getByModel(String model);

    List<T> getByReleaseDate(LocalDate releaseDate);

    List<T> getByRAMAndSSD(int ramSize, int ssdCapacity);

    List<T> getByProcessor(String processor);

    void deleteByProcessor(String processor);

    void deleteByRAMAndSSD(int ramSize, int ssdCapacity);
}
