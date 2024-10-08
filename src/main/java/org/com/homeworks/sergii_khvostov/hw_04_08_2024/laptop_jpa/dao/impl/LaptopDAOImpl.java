package org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.dao.impl;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.dao.LaptopDAO;
import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.db_connection.Requests;
import org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.domain.LaptopJPA;

import java.time.LocalDate;
import java.util.List;

public class LaptopDAOImpl implements LaptopDAO<LaptopJPA> {

    private EntityManager createEntityManager() {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Requests.FACTORY_NAME);
        return factory.createEntityManager();
    }

    @Override
    public void add(LaptopJPA entity) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(entity);

        transaction.commit();
    }

    @Override
    public LaptopJPA getById(int id) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<LaptopJPA> query = em.createQuery(Requests.GET_BY_ID, LaptopJPA.class);

        query.setParameter(Requests.SET_ID, id);

        LaptopJPA laptops = query.getSingleResult();

        System.out.println(laptops);

        transaction.commit();

        return laptops;
    }

    @Override
    public List<LaptopJPA> getAll() {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<LaptopJPA> query = em.createQuery(Requests.GET_ALL, LaptopJPA.class);

        List<LaptopJPA> laptops = query.getResultList();

        System.out.println(laptops);

        transaction.commit();

        return laptops;
    }

    @Override
    public void deleteById(int id) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Query query = em.createQuery(Requests.DELETE_BY_ID);

        query.setParameter(Requests.SET_ID, id);

        query.executeUpdate();

        transaction.commit();
    }

    @Override
    public void deleteAll() {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Query query = em.createQuery(Requests.DELETE_ALL);

        query.executeUpdate();

        transaction.commit();

    }

    @Override
    public void update(LaptopJPA entity) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        LaptopJPA laptop = em.merge(entity);

        em.persist(laptop);

        /*Query query = em.createQuery(Requests.UPDATE);

        query.setParameter("model", entity.getModel());
        query.setParameter("manufacturer", entity.getManufacturer());
        query.setParameter("releaseDate", entity.getReleaseDate());
        query.setParameter("ramSize", entity.getRamSize());
        query.setParameter("ssdCapacity", entity.getSsdCapacity());

        query.setParameter(Requests.SET_ID, entity.getId());

        query.executeUpdate();*/

        transaction.commit();
    }

    @Override
    public List<LaptopJPA> getByModel(String model) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<LaptopJPA> query = em.createQuery(Requests.GET_BY_MODEL, LaptopJPA.class);

        query.setParameter(Requests.SET_MODEL, model);

        List<LaptopJPA> laptops = query.getResultList();

        System.out.println(laptops);

        transaction.commit();

        return laptops;

    }

    @Override
    public List<LaptopJPA> getByReleaseDate(LocalDate releaseDate) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<LaptopJPA> query = em.createQuery(Requests.GET_BY_RELEASEDATE, LaptopJPA.class);

        query.setParameter(Requests.SET_RELEASEDATE, releaseDate);

        List<LaptopJPA> laptops = query.getResultList();

        System.out.println(laptops);

        transaction.commit();

        return laptops;
    }

    @Override
    public List<LaptopJPA> getByRAMAndSSD(int ramSize, int ssdCapacity) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<LaptopJPA> query = em.createQuery(Requests.GET_BY_RAM_AND_SSD, LaptopJPA.class);

        query.setParameter(Requests.SET_RAMSIZE, ramSize);
        query.setParameter(Requests.SET_SSDCAPACITY, ssdCapacity);

        List<LaptopJPA> laptops = query.getResultList();

        System.out.println(laptops);

        transaction.commit();

        return laptops;
    }

    @Override
    public List<LaptopJPA> getByProcessor(String processor) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<LaptopJPA> query = em.createQuery(Requests.GET_BY_PROCESSOR, LaptopJPA.class);

        query.setParameter(Requests.SET_PROCESSOR, processor);

        List<LaptopJPA> laptops = query.getResultList();

        System.out.println(laptops);

        transaction.commit();

        return laptops;
    }

    @Override
    public void deleteByProcessor(String processor) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Query query = em.createQuery(Requests.DELETE_BY_PROCESSOR);

        query.setParameter(Requests.SET_PROCESSOR, processor);

        query.executeUpdate();

        transaction.commit();
    }

    @Override
    public void deleteByRAMAndSSD(int ramSize, int ssdCapacity) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Query query = em.createQuery(Requests.DELETE_BY_RAM_AND_SSD);

        query.setParameter(Requests.SET_RAMSIZE, ramSize);
        query.setParameter(Requests.SET_SSDCAPACITY, ssdCapacity);

        query.executeUpdate();

        transaction.commit();
    }
}
