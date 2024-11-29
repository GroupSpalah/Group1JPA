package org.com.homeworks.dmytro_k.hw_04_08_24.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.GenericLaptopDao;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.LaptopDAOFactory;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.LaptopDocument;
import org.com.homeworks.dmytro_k.hw_04_08_24.service.LaptopService;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class MongoDbLaptopServiceImpl implements LaptopService<LaptopDocument, ObjectId> {

    LaptopDAOFactory LAPTOP_DAO_FACTORY_MONGO_DB = LaptopDAOFactory.getInstance(2);
    GenericLaptopDao<LaptopDocument, ObjectId> LAPTOP_DAO = LAPTOP_DAO_FACTORY_MONGO_DB.getLaptopDao();
    //Из-за различий в типах данных для разных БД, шаблон DAO_FACTORY не кажется полезным в этом случае

    public void addLaptop(LaptopDocument laptop) {
        LAPTOP_DAO.addLaptop(laptop);
    }

    public LaptopDocument findById(ObjectId id) {
        return LAPTOP_DAO.findById(id);
    }

    public void printAllLaptop() {
        LAPTOP_DAO.printAllLaptop();
    }

    public void filterByReleaseDate(LocalDate date) {
        LAPTOP_DAO.filterByReleaseDate(date);
    }

    public void filterByTwoParam(String firstParam, String secondParam,
                                 Object firstValue, Object secondValue) {
        LAPTOP_DAO.filterByTwoParam(firstParam, secondParam, firstValue, secondValue);
    }

    public void filterByModel(String value) {
        LAPTOP_DAO.filterByModel(value);
    }

    public void filerByProcessor(String value) {
        LAPTOP_DAO.filerByProcessor(value);
    }

    public void deleteByProcessor(String value) {
        LAPTOP_DAO.deleteByProcessor(value);
    }

    public void deleteByRamAndSsd(int firstParam, int secondParam) {
        LAPTOP_DAO.deleteByRamAndSsd(firstParam, secondParam);
    }

    public void update(LaptopDocument laptop) {
        LAPTOP_DAO.update(laptop);
    }

    public List<LaptopDocument> getAllLaptop() {
        return LAPTOP_DAO.getAllLaptop();
    }
}
