package org.com.homeworks.dmytro_k.hw_04_08_24.dao.mongoDbDAOimpl;

import org.bson.types.ObjectId;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.LaptopDAOFactory;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.GenericLaptopDao;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.LaptopDocument;

public class MongoDbLaptopDAOFactory extends LaptopDAOFactory {

    @Override
    public GenericLaptopDao<LaptopDocument, ObjectId> getLaptopDao() {
        return new MongoDbGenericLaptopDaoImpl();    }

}
