package org.com.homeworks.dmytro_k.hw_04_08_24;

import org.bson.types.ObjectId;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.LaptopDAOFactory;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.GenericLaptopDao;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.MySQLDAOimpl.MySQLLaptopDaoImpl;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.mongoDbDAOimpl.MongoDbGenericLaptopDaoImpl;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.LaptopDocument;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.Laptop;
import org.com.homeworks.dmytro_k.hw_04_08_24.service.LaptopService;
import org.com.homeworks.dmytro_k.hw_04_08_24.service.impl.MongoDbLaptopServiceImpl;
import org.com.homeworks.dmytro_k.hw_04_08_24.service.impl.MySQLLaptopServiceImpl;

import java.time.LocalDate;
import java.util.List;

/**
 * --
 * 2. Розробіть інтерфейс, котрий міститиме необхідні операції над даними. Перелік операцій:
 * ++ a) додавання;
 * ++ б) перегляд за id;
 * ++ в) перегляд повного переліку;
 * г) видалення за id;
 * д) видалення повного переліку;
 * е) модифікація за id;
 * ++ 1) Delete notebook by processor
 * ++ 2) Delete notebook by RAM and SSD
 * ++ є) перегляд за моделлю;
 * ++ ж) перегляд за датою випуску;
 * ++ з) перегляд за об’ємом оперативної пам’яті та місткістю SSD;
 * ++ и) перегляд за процесором.
 * <p>
 * 3. Розробіть репозиторій на основі інтерфейсу (п. 2). Реалізуйте його методи.
 * 4. Побудуйте сервіс, що використовує отриманий у п. 3 репозиторій.
 * 5. Розробіть контролер для обробки запитів користувача.
 * 6. Продемонструйте розроблений проект у дії. Скористайтеся для надсилання запитів до сервера
 * API-клієнтом (Postman, Insomnia тощо). Формат тіла HTTP-запитів та відповідей сервера — JSON.
 * <p>
 * ++Додати сервісний слой !!!
 * <p>
 * ++1) Update Laptop in separate method
 */

public class LaptopsDataBaseAppTest {
    public static void main(String[] args) {

        ObjectId objectId = new ObjectId("673f9ed67369ec07f0ccbad3");

        Laptop newLenovo = Laptop.builder()
                .model("Yoga Slim 60")
                .manufacturer("Lenovo")
                .releaseDate(LocalDate.of(2025, 4, 20))
                .RAMCapacity(64)
                .SSDCapacity(2048)
                .processor("Intel Core i9-1585G9")
                //.id(1)//нужна генерация
                .build();

        LaptopDocument newLenovoD = LaptopDocument.builder()
                .model("Yoga Slim 20")
                .manufacturer("Lenovo")
                .releaseDate(LocalDate.of(2025, 4, 20))
                .ramCapacity(32)
                .ssdCapacity(2048)
                .processor("Intel Core i5-1585G9")
                //.id(objectId)//нужна генерация
                .build();

        /***
         * Тест DAOFactory
         */

        LaptopDAOFactory laptopDAOFactorySQL = LaptopDAOFactory.getInstance(1);
        LaptopDAOFactory laptopDAOFactoryMongoDb = LaptopDAOFactory.getInstance(2);

        GenericLaptopDao laptopEntityDao1 = new MySQLLaptopDaoImpl();

        GenericLaptopDao genericLaptopDaoMySql = laptopDAOFactorySQL.getLaptopDao();//то же самое

        GenericLaptopDao genericLaptopDaoMongo = laptopDAOFactoryMongoDb.getLaptopDao(); // вынести это через сервис++

        /**
         * Dao test
         */
        //genericLaptopDao.addLaptop(newLenovoD);//++
        //genericLaptopDao.printAllLaptop();//++
        //System.out.println(genericLaptopDao.findById(objectId));//++
        //genericLaptopDao.filerByProcessor("Intel Core i5-1585G9");//++ работает только полное совпадение, частичное совпадение значения не выводит
        //genericLaptopDao.deleteByRamAndSsd(32, 2048);//++ удаляет по полному совпадению двух значений
        //genericLaptopDao.filterByReleaseDate(LocalDate.of(2025, 4, 20));//++
        //регистр имеет значение при указании поля для фильтрации. Автоматически поле записывается в базу с маленькой буквы.
        //genericLaptopDao.filterByTwoParam("model", "ramCapacity", "Yoga Slim 20", 32);//++

        //genericLaptopDao.filterByTwoParam("model", "ramCapacity", "Yoga Slim 20", 42);//++

        //laptopDocumentDao.update(newLenovoD);//++

        /**
         * Service test
         */

        LaptopService<LaptopDocument, ObjectId> laptopServiceMongoDB = new MongoDbLaptopServiceImpl();
        LaptopService<Laptop, Integer> laptopServiceMySQL = new MySQLLaptopServiceImpl();

        //laptopServiceMongoDB.addLaptop(newLenovoD);//++
        //laptopServiceMongoDB.printAllLaptop();//++
        laptopServiceMySQL.printAllLaptop();//++

        //вытащить ноутбуки с MySQL и записать в MongoDB в одном методе:


        /**
         * Перенос таблицы тест
         */

        //carryOver();//++ перенос таблицы SQL в Mongo

        laptopServiceMongoDB.getAllLaptop().forEach(System.out::println);//++



        //тест старого функционала (на 1 базу)

        //laptopDao.addLaptop(newLenovo);
        //laptopDao1.addLaptop(newLenovo);//тоже самое

/*        System.out.println(laptopDao.findById(1));

        //получить все записи
        laptopDao.printAllLaptop();

        //получить записи по модели
        laptopDao.filterByModel(MODEL, "Yoga Slim 7");

        //получить записи по дате выпуска
        laptopDao.filterByReleaseDate(LocalDate.of(2022, 1, 25));

        //получить записи по RAMCapacity и SSDCapacity
        laptopDao.filterByTwoParam(FILTER_BY_RAM_AND_SSD, RAM_CAPACITY, SSD_CAPACITY, 16, 512);

        //получить записи по processor
        laptopDao.filerByProcessor(PROCESSOR, "%intel%");

        //удалить записи по processor
        //laptopDao.deleteByProcessor("%Intel Core i9-1485G9%");

        //удалить записи по RAM and SSD
        //laptopDao.deleteByRamAndSsd(1, 16);

        LaptopService laptopService = new LaptopServiceImpl();
        //laptopService.update(newLenovo);*/
    }

    //перенос таблицы ноутбуков в MongoDB
    static void carryOver() {
        GenericLaptopDao<Laptop, Integer> laptopDao = new MySQLLaptopDaoImpl();
        GenericLaptopDao<LaptopDocument, ObjectId> laptopDocumentDao = new MongoDbGenericLaptopDaoImpl();

        List<Laptop> allLaptop = laptopDao.getAllLaptop();
        
        allLaptop.forEach(i -> {
            String model = i.getModel();
            String processor = i.getProcessor();
            LocalDate releaseDate = i.getReleaseDate();
            int ssdCapacity = i.getSSDCapacity();
            int ramCapacity = i.getRAMCapacity();
            String manufacturer = i.getManufacturer();

            LaptopDocument laptopDocument = LaptopDocument
                    .builder()
                    .model(model)
                    .manufacturer(manufacturer)
                    .releaseDate(releaseDate)
                    .ramCapacity(ramCapacity)
                    .ssdCapacity(ssdCapacity)
                    .processor(processor)
                    .build();

            laptopDocumentDao.addLaptop(laptopDocument);
        });
    }
}
