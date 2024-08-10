package org.com.homeworks.vladyslav_lazin.hw_04_08_24.service;


import java.util.List;
import java.time.LocalDate;

import org.com.homeworks.vladyslav_lazin.hw_04_08_24.domain.Laptop;

public interface LaptopService {
    void save(Laptop laptop);

    Laptop findById(int id);

    List<Laptop> findAll();

    void deleteById(int id);

    void deleteAll();

    void deleteByRamAndSsd(int ram, int ssd);

    void deleteByCpu(String cpu);

    void update(int id, Laptop laptop);

    List<Laptop> findByModel(String model);

    List<Laptop> findByProdDate(LocalDate prodDate);

    List<Laptop> findByRamAndSsd(int ram, int ssd);
    
    List<Laptop> findByCpu(String cpu);
}
