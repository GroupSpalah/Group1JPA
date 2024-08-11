package org.com.homeworks.dmytro_k.hw_04_08_24.dao.impl;

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
import org.com.homeworks.dmytro_k.hw_04_08_24.dao.LaptopDao;
import org.com.homeworks.dmytro_k.hw_04_08_24.domain.Laptop;

import java.time.LocalDate;
import java.util.List;

import static org.com.homeworks.dmytro_k.hw_04_08_24.util.ConstantsUtil.*;

public class LaptopDaoImpl implements LaptopDao {

    public void addLaptop(Laptop laptop) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(laptop);

        transaction.commit();
    }

    public Laptop findById(int id) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Laptop laptop = em.find(Laptop.class, id);
        transaction.commit();
        return laptop;
    }

    public void printAllLaptop() {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Laptop> query = em.createQuery(ALL_LAPTOP, Laptop.class);
        List<Laptop> laptopList = query.getResultList();
        System.out.println(laptopList);
        transaction.commit();
    }

    private void filterByParam(String inputQuery, String param, String value) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Laptop> query = em.createQuery(FILTER_BY_RELEASE_DATE,
                Laptop.class);
        query.setParameter(RELEASE_DATE, date);
        List<Laptop> laptopList = query.getResultList();
        System.out.println(laptopList);
        transaction.commit();
    }

    public void filterByTwoParam(String inputQuery, String firstParam, String secondParam,
                                 int firstValue, int secondValue) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Laptop> query = em.createQuery(inputQuery, Laptop.class);
        query.setParameter(firstParam, firstValue);
        query.setParameter(secondParam, secondValue);
        List<Laptop> laptopList = query.getResultList();
        System.out.println(laptopList);
        transaction.commit();
    }

    public void filterByModel(String param, String value) {
        filterByParam(FILTER_BY_MODEL, param, value);
    }

    public void filerByProcessor(String param, String value) {
        filterByParam(FILTER_BY_PROCESSOR, param, value);
    }

    public void deleteByProcessor(String value) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(DELETE_BY_RAM_AND_SSD);
        query.setParameter(RAM_CAPACITY, firstParam);
        query.setParameter(SSD_CAPACITY, secondParam);
        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);

        transaction.commit();
    }
}
