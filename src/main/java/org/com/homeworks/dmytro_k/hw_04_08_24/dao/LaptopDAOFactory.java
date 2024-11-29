package org.com.homeworks.dmytro_k.hw_04_08_24.dao;

import org.com.homeworks.dmytro_k.hw_04_08_24.dao.MySQLDAOimpl.MySQLLaptopDAOFactory;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.mongoDbDAOimpl.MongoDbLaptopDAOFactory;
import org.jetbrains.annotations.NotNull;

public abstract class LaptopDAOFactory {

    public abstract GenericLaptopDao getLaptopDao();

    public static @NotNull LaptopDAOFactory getInstance(int DbId) {
        return switch (DbId) {
            case 1 -> new MySQLLaptopDAOFactory();
            case 2 -> new MongoDbLaptopDAOFactory();
            default -> new MongoDbLaptopDAOFactory();
        };
    }
}
