package org.com.homeworks.vladyslav_lazin.hw_04_08_24.dao.impl;

import java.util.List;
import java.time.LocalDate;

import org.com.homeworks.vladyslav_lazin.hw_04_08_24.dao.LaptopDao;
import org.com.homeworks.vladyslav_lazin.hw_04_08_24.domain.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class LaptopDaoImpl implements LaptopDao {

    @Override
    public void save(Laptop laptop) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(laptop);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public Laptop findById(int id) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Laptop laptop = entityManager.find(Laptop.class, id);
        transaction.commit();
        entityManager.close();
        if (laptop == null) {
            throw new RuntimeException("Laptop with id " + id + " not found");
            
        }

        return laptop;
    }

    @Override
    public List<Laptop> findAll() {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<Laptop> query = entityManager.createQuery("FROM Laptop l", Laptop.class);
        List<Laptop> laptops = query.getResultList();
        transaction.commit();
        entityManager.close();

        return laptops;
    }

    @Override
    public void deleteById(int id) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Laptop l WHERE l.id =: lId");
        query.setParameter("lId", id);
        query.executeUpdate();
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Laptop l");
        query.executeUpdate();
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void update(Laptop laptop) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        
        Laptop newLaptop = entityManager.merge(laptop);
        entityManager.persist(newLaptop);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<Laptop> findByModel(String model) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<Laptop> typedQuery = entityManager.createQuery("FROM Laptop l WHERE l.model LIKE :lModel", Laptop.class);
        typedQuery.setParameter("lModel", model);
        List<Laptop> laptops = typedQuery.getResultList();
        transaction.commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public List<Laptop> findByProdDate(LocalDate prodDate) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<Laptop> typedQuery = entityManager.createQuery("FROM Laptop l WHERE l.prodDate =: lPd", Laptop.class);
        typedQuery.setParameter("lPd", prodDate);
        List<Laptop> laptops = typedQuery.getResultList();
        transaction.commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public List<Laptop> findByRamAndSsd(int ram, int ssd) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<Laptop> typedQuery = entityManager.createQuery("FROM Laptop l WHERE l.ramCapacity = :lRam" +
                " AND l.ssdCapacity =: lSsd", Laptop.class);
                
        typedQuery.setParameter("lRam", ram);
        typedQuery.setParameter("lSsd", ssd);

        List<Laptop> laptops = typedQuery.getResultList();
        transaction.commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public List<Laptop> findByCpu(String cpu) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        TypedQuery<Laptop> typedQuery = entityManager.createQuery("FROM Laptop l WHERE l.cpuName =: cpu", Laptop.class);
        typedQuery.setParameter("cpu", cpu);
        transaction.begin();
        List<Laptop> laptops = typedQuery.getResultList();
        transaction.commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public void deleteByRamAndSsd(int ram, int ssd) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Laptop l WHERE l.ramCapacity = :lRam AND l.ssdCapacity = :lSsd");
        query.setParameter("lRam", ram);
        query.setParameter("lSsd", ssd);
        query.executeUpdate();
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteByCpu(String cpu) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Laptop l WHERE l.cpuName = :lCpu");
        query.setParameter("lCpu", cpu);
        query.executeUpdate();
        transaction.commit();
        entityManager.close();
    }

}
