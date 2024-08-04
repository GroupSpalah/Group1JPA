package homeworks.vladyslav_lazin.hw_2024.hw_02_06_24.service.impl;

import homeworks.vladyslav_lazin.hw_2024.hw_02_06_24.dao.LaptopDao;
import homeworks.vladyslav_lazin.hw_2024.hw_02_06_24.entity.Laptop;
import homeworks.vladyslav_lazin.hw_2024.hw_02_06_24.service.LaptopService;

import java.util.List;

public class LaptopServiceImpl implements LaptopService {
    LaptopDao laptopDao;
    @Override
    public void addLaptop(Laptop laptop) {
        laptopDao.addLaptop(laptop);
    }

    @Override
    public Laptop findLaptopById(int id) {
        return laptopDao.findLaptopById(id);
    }

    @Override
    public List<Laptop> findAllLaptops() {
        return laptopDao.findAllLaptops();
    }

    @Override
    public void deletLaptopbyId(int id) {
        laptopDao.findLaptopById(id);
    }

    @Override
    public void deleteAllLaptops() {
        laptopDao.deleteAllLaptops();
    }

    @Override
    public void updateLaptopById(int id, Laptop laptop) {
        laptopDao.updateLaptopById(id, laptop);
    }

    @Override
    public List<Laptop> findLaptopByModel(String model) {
        return laptopDao.findLaptopByModel(model);
    }

    @Override
    public List<Laptop> findLaptopByProdDate(String prodDate) {
        return laptopDao.findLaptopByProdDate(prodDate);
    }

    @Override
    public List<Laptop> findLaptopByRamAnadSsd(int ram, int ssd) {
        return laptopDao.findLaptopByRamAnadSsd(ram, ssd);
    }

    @Override
    public List<Laptop> findLaptopByCpu(String cpu) {
        return laptopDao.findLaptopByCpu(cpu);
    }
}
