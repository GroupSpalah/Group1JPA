package org.com.homeworks.dmytro_k.hw_04_08_24.util;

public class ConstantsUtil {

    public static final String DELETE_BY_RAM_AND_SSD = "DELETE FROM Laptop l " +
            "WHERE l.RAMCapacity = :RAM_Capacity " +
            "AND l.SSDCapacity = :SSD_Capacity";
    public static final String RAM_CAPACITY = "RAM_Capacity";
    public static final String SSD_CAPACITY = "SSD_Capacity";
    public static final String DELETE_BY_PROCESSOR = "DELETE FROM Laptop l " +
            "WHERE l.processor " +
            "LIKE :processor";
    public static final String PROCESSOR = "processor";
    public static final String FILTER_BY_PROCESSOR = "SELECT l FROM Laptop l " +
            "WHERE l.processor " +
            "LIKE :processor";
    public static final String FILTER_BY_RAM_AND_SSD = "SELECT l FROM Laptop l " +
            "WHERE l.RAMCapacity = :RAMCapacity " +
            "AND l.SSDCapacity = :SSDCapacity";
    public static final String FILTER_BY_RELEASE_DATE = "SELECT l FROM Laptop l " +
            "WHERE l.releaseDate = :releaseDate";
    public static final String RELEASE_DATE = "releaseDate";
    public static final String FILTER_BY_MODEL = "SELECT l FROM Laptop l " +
            "WHERE l.model = :model";
    public static final String MODEL = "model";
    public static final String ALL_LAPTOP = "SELECT l FROM Laptop l";
    public static final String UNIT_NAME = "test-dmytro";
}
