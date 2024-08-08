package org.com.homeworks.vladyslav_lazin.hw_04_08_24.dao;


import java.util.List;
import java.time.LocalDate;

import org.com.homeworks.vladyslav_lazin.hw_04_08_24.domain.Laptop;

public interface LaptopDao {
    void save(Laptop laptop);

    Laptop findById(int id);

    List<Laptop> findAll();

    void deleteById(int id);

    void deleteAll();

    void update(int id, Laptop laptop);

    List<Laptop> findByModel(String model);

    List<Laptop> findByProdDate(LocalDate prodDate);

    List<Laptop> findByRamAndSsd(int ram, int ssd);
    
    List<Laptop> findByCpu(String cpu);

}
