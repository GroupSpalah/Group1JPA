package org.com.homeworks.dmytro_k.hw_04_08_24.dao.MySQLDAOimpl;

import org.com.homeworks.dmytro_k.hw_04_08_24.dao.LaptopDAOFactory;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.GenericLaptopDao;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.Laptop;

public class MySQLLaptopDAOFactory extends LaptopDAOFactory {

    @Override
    public GenericLaptopDao<Laptop, Integer> getLaptopDao() {
        return new MySQLLaptopDaoImpl();
    }
}
