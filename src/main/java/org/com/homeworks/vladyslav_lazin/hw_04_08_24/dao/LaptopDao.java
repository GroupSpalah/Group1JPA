package homeworks.vladyslav_lazin.hw_2024.hw_02_06_24.dao;

import homeworks.vladyslav_lazin.hw_2024.hw_02_06_24.entity.Laptop;

import java.util.List;

public interface LaptopDao {
    void addLaptop(Laptop laptop);
    Laptop findLaptopById(int id);
    List<Laptop> findAllLaptops();
    void deletLaptopbyId(int id);
    void deleteAllLaptops();
    void updateLaptopById(int id, Laptop laptop);
    List<Laptop> findLaptopByModel(String model);
    List<Laptop> findLaptopByProdDate(String prodDate);
    List<Laptop> findLaptopByRamAnadSsd(int ram, int ssd);
    List<Laptop> findLaptopByCpu(String cpu);

}
