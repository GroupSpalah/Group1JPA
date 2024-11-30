package org.com.homeworks.dmytro_k.hw_04_08_24.dao.mongoDbDAOimpl;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.types.ObjectId;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.GenericLaptopDao;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.LaptopDocument;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.com.homeworks.dmytro_k.hw_04_08_24.mongo_config.MongoClientManager.getMongoClient;
import static org.com.homeworks.dmytro_k.hw_04_08_24.util.ConstantsUtil.*;

public class MongoDbGenericLaptopDaoImpl implements GenericLaptopDao<LaptopDocument, ObjectId> {

    private final MongoCollection<LaptopDocument> laptopsCollection;

    public MongoDbGenericLaptopDaoImpl() {
        MongoDatabase database = getMongoClient().getDatabase(DATABASE_NAME);
        this.laptopsCollection = database.getCollection(COLLECTION_NAME, LaptopDocument.class);
    }

    @Override
    public void addLaptop(LaptopDocument laptop) {
        InsertOneResult result = laptopsCollection.insertOne(laptop);
        System.out.println("Success! Inserted document id: " + result.getInsertedId());
    }

    @Override
    public LaptopDocument findById(ObjectId id) {
        return laptopsCollection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public void printAllLaptop() {
        laptopsCollection
                .find()
                .into(new ArrayList<>())
                .forEach(System.out::println);
    }


    @Override
    public void filterByReleaseDate(LocalDate date) {
        //laptopsCollection
        //        .find()
        //        .into(new ArrayList<>())
        //        .stream()
        //        .filter(i -> i.getReleaseDate().equals(date))
        //        .forEach(System.out::println); //обработка на уровне приложения - напрасная трата ресурсов.

        filterByParam(RELEASE_DATE_JAVA, date);
    }

    @Override
    public void filterByTwoParam(String firstParam, String secondParam, Object firstValue, Object secondValue) {
        //laptopsCollection
        //        .find(Filters.eq(firstParam, firstValue))
        //        .filter(Filters.eq(secondParam, secondValue))
        //        .forEach(System.out::println);//альтернативный вариант

        // фильтрует только по двум параметрам:
        //laptopsCollection
        //        .find(Filters.and(Filters.eq(firstParam, firstValue), Filters.eq(secondParam, secondValue)))
        //        .forEach(System.out::println);//++

        // фильтрует по первому, второму, или сразу двум параметрам:
        laptopsCollection
                .find(Filters.or(Filters.eq(firstParam, firstValue), Filters.eq(secondParam, secondValue)))
                .forEach(System.out::println);
    }

    @Override
    public void filterByModel(String value) {
        filterByParam(MODEL, value);
    }

    @Override
    public void filerByProcessor(String value) {
        filterByParam(PROCESSOR, value);
    }

    private void filterByParam(String param, Object value) {
        laptopsCollection
                .find(Filters.eq(param, value))
                .forEach(System.out::println);
    }

    @Override
    public void deleteByProcessor(String value) {
        laptopsCollection
                .deleteMany(
                        Filters.eq(PROCESSOR, value)
                );
    }

    @Override
    public void deleteByRamAndSsd(int ram, int ssd) {
        laptopsCollection
                .deleteMany(Filters.and(Filters.eq(RAM_CAPACITY_JAVA, ram),
                        Filters.eq(SSD_CAPACITY_JAVA, ssd)));
    }

    @Override
    public void update(LaptopDocument laptopDocument) {
        laptopsCollection
                .replaceOne(Filters.eq("_id", laptopDocument.getId())
                        , laptopDocument);
    }

    public List<LaptopDocument> getAllLaptop() {
        List<LaptopDocument> allLaptop = new ArrayList<>();

        laptopsCollection.find().forEach(allLaptop::add);
        return allLaptop;
    }
}
