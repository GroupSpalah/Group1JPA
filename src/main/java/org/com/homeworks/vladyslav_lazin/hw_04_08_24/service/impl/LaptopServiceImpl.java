package org.com.homeworks.vladyslav_lazin.hw_04_08_24.service.impl;


import java.util.List;
import java.time.LocalDate;

import org.com.homeworks.vladyslav_lazin.hw_04_08_24.dao.LaptopDao;
import org.com.homeworks.vladyslav_lazin.hw_04_08_24.dao.impl.LaptopDaoImpl;
import org.com.homeworks.vladyslav_lazin.hw_04_08_24.domain.Laptop;
import org.com.homeworks.vladyslav_lazin.hw_04_08_24.service.LaptopService;

public class LaptopServiceImpl implements LaptopService {
    LaptopDao laptopDao;

    public LaptopServiceImpl() {
        laptopDao = new LaptopDaoImpl();
    }

    @Override
    public void save(Laptop laptop) {
        laptopDao.save(laptop);
    }

    @Override
    public Laptop findById(int id) {
        return laptopDao.findById(id);
    }

    @Override
    public List<Laptop> findAll() {
        return laptopDao.findAll();
    }

    @Override
    public void deleteById(int id) {
        laptopDao.deleteById(id);   
    }

    @Override
    public void deleteAll() {
        laptopDao.deleteAll();
    }

    @Override
    public void update(int id, Laptop laptop) {
        laptopDao.update(id, laptop);
    }

    @Override
    public List<Laptop> findByModel(String model) {
        return laptopDao.findByModel(model);    }

    @Override
    public List<Laptop> findByProdDate(LocalDate prodDate) {
        return laptopDao.findByProdDate(prodDate);
    }

    @Override
    public List<Laptop> findByRamAndSsd(int ram, int ssd) {
        return laptopDao.findByRamAndSsd(ram, ssd);
    }

    @Override
    public List<Laptop> findByCpu(String cpu) {
        return laptopDao.findByCpu(cpu);
    }

    @Override
    public void deleteByRamAndSsd(int ram, int ssd) {
       laptopDao.deleteByRamAndSsd(ram, ssd);
    }

    @Override
    public void deleteByCpu(String cpu) {
        laptopDao.deleteByCpu(cpu);
    }
}
