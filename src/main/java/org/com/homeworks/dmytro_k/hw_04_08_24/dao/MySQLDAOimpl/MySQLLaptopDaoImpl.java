package org.com.homeworks.dmytro_k.hw_04_08_24.dao.MySQLDAOimpl;

/**
 * ---
 * Завдання 6
 * <p>
 * ++ 1. Напишіть клас, що описує ноутбук на фірмі. Поля класу:
 * a) модель;
 * б) виробник;
 * в) дата випуску;
 * г) об’єм оперативної пам’яті;
 * д) місткість SSD;
 * е) процесор;
 * є) id.
 * <p>
 * ++ Типи полів задайте самостійно.
 * <p>
 * 2. Розробіть інтерфейс, котрий міститиме необхідні операції над даними. Перелік операцій:
 * ++ a) додавання;
 * ++ б) перегляд за id;
 * ++ в) перегляд повного переліку;
 * ++ г) видалення за id;
 * ++ д) видалення повного переліку;
 * ++ е) модифікація за id;
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
 * ---
 */

import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.GenericLaptopDao;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.Laptop;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;

import static org.com.homeworks.dmytro_k.hw_04_08_24.util.ConstantsUtil.*;

public class MySQLLaptopDaoImpl implements GenericLaptopDao<Laptop, Integer> {

    public void addLaptop(Laptop laptop) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(laptop);

        transaction.commit();
    }

    public Laptop findById(Integer id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Laptop laptop = em.find(Laptop.class, id);
        transaction.commit();
        return laptop;
    }

    public void printAllLaptop() {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Laptop> query = em.createQuery(ALL_LAPTOP, Laptop.class);
        List<Laptop> laptopList = query.getResultList();
        System.out.println(laptopList);
        transaction.commit();
    }

    public List<Laptop> getAllLaptop() {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Laptop> query = em.createQuery(ALL_LAPTOP, Laptop.class);
        List<Laptop> laptopList = query.getResultList();
        transaction.commit();
        return laptopList;
    }

    private void filterByParam(String inputQuery, String param, String value) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Laptop> query = em.createQuery(inputQuery, Laptop.class);
        query.setParameter(param, value);
        List<Laptop> laptopList = query.getResultList();
        System.out.println(laptopList);
        transaction.commit();
    }

    public void filterByReleaseDate(LocalDate date) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Laptop> query = em.createQuery(FILTER_BY_RELEASE_DATE,
                Laptop.class);
        query.setParameter(RELEASE_DATE, date);
        List<Laptop> laptopList = query.getResultList();
        System.out.println(laptopList);
        transaction.commit();
    }

    public void filterByTwoParam(/*String inputQuery,*/ String firstParam, String secondParam,
                                                        java.lang.Object firstValue, java.lang.Object secondValue) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<Laptop> query = em.createQuery(FILTER_BY_RAM_AND_SSD, Laptop.class);
        query.setParameter(firstParam, firstValue);
        query.setParameter(secondParam, secondValue);

        List<Laptop> laptopList = query.getResultList();
        System.out.println(laptopList);
        transaction.commit();
    }

    public void filterByModel(String value) {
        filterByParam(FILTER_BY_MODEL, MODEL, value);
    }

    public void filerByProcessor(String value) {
        filterByParam(FILTER_BY_PROCESSOR, PROCESSOR, value);
    }

    public void deleteByProcessor(String value) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(DELETE_BY_PROCESSOR);
        query.setParameter(PROCESSOR, value);
        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }

    public void deleteByRamAndSsd(int firstParam, int secondParam) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(DELETE_BY_RAM_AND_SSD);
        query.setParameter(RAM_CAPACITY, firstParam);
        query.setParameter(SSD_CAPACITY, secondParam);
        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);

        transaction.commit();
    }

    public void update(@NotNull Laptop laptop) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(UPDATE);

        query.setParameter(MODEL, laptop.getModel());
        query.setParameter(MANUFACTURER, laptop.getManufacturer());
        query.setParameter(RELEASE_DATE, laptop.getReleaseDate());
        query.setParameter(RAM_CAPACITY, laptop.getRAMCapacity());
        query.setParameter(SSD_CAPACITY, laptop.getSSDCapacity());
        query.setParameter(PROCESSOR, laptop.getProcessor());
        query.setParameter(LAPTOP_ID, laptop.getId());

        query.executeUpdate();

        transaction.commit();
    }
}
