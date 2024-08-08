package org.com.homeworks.vladyslav_lazin.hw_04_08_24;

import org.com.homeworks.vladyslav_lazin.hw_04_08_24.domain.Laptop;
import org.com.homeworks.vladyslav_lazin.hw_04_08_24.service.LaptopService;
import org.com.homeworks.vladyslav_lazin.hw_04_08_24.service.impl.LaptopServiceImpl;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        LaptopService laptopService = new LaptopServiceImpl();

        // Laptop laptop = Laptop
        //         .builder()
        //         .model("Vostro")
        //         .manufacturer("Dell")
        //         .prodDate(LocalDate.of(2021, 6, 30))
        //         .ramCapacity(16)
        //         .ssdCapacity(512)
        //         .cpu("Intel Core i5").build();
        // laptopService.save(laptop);

        // System.out.println(laptopService.findByRamAndSsd(32, 1024));
        // System.out.println(laptopService.findByModel("Vostro"));
        System.out.println(laptopService.findByCpu("AMD Ryzen 7"));
    }
}
