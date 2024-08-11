package org.com.homeworks.dmytro_k.hw_04_08_24;

import org.com.homeworks.dmytro_k.hw_04_08_24.dao.LaptopDao;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.impl.LaptopDaoImpl;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.Laptop;
import java.time.LocalDate;

import static org.com.homeworks.dmytro_k.hw_04_08_24.util.ConstantsUtil.*;

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
 */

public class LaptopsDataBaseAppTest {
    public static void main(String[] args) {

        Laptop newLenovo = Laptop.builder()
                .model("Yoga Slim 15")
                .manufacturer("Lenovo")
                .releaseDate(LocalDate.of(2024, 1, 25))
                .RAMCapacity(32)
                .SSDCapacity(2048)
                .processor("Intel Core i9-1485G9")
                .build();

        LaptopDao laptopDao = new LaptopDaoImpl();

        //laptopDao.addLaptop(newLenovo);

        //System.out.println(laptopDao.findById(1));

        //получить все записи
        //laptopDao.printAllLaptop();

        //получить записи по модели
        //laptopDao.filterByModel(MODEL, "Yoga Slim 7");

        //получить записи по дате выпуска
        laptopDao.filterByReleaseDate(LocalDate.of(2022, 1, 25));

        //получить записи по RAMCapacity и SSDCapacity
/*        laptopDao.filterByTwoParam(FILTER_BY_RAM_AND_SSD, RAM_CAPACITY, SSD_CAPACITY, 16, 512);

        //получить записи по processor
        laptopDao.filerByProcessor(PROCESSOR, "%intel%");

        //удалить записи по processor
        laptopDao.deleteByProcessor("%Intel Core i9-1485G9%");

        //удалить записи по RAM and SSD
        laptopDao.deleteByRamAndSsd(1, 16);*/
    }
}
