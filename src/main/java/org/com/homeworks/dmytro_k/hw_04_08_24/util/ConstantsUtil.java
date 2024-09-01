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
            "WHERE l.RAMCapacity = :RAM_Capacity " +
            "AND l.SSDCapacity = :SSD_Capacity";
    public static final String FILTER_BY_RELEASE_DATE = "SELECT l FROM Laptop l " +
            "WHERE l.releaseDate = :release_date";
    public static final String RELEASE_DATE = "release_date";
    public static final String FILTER_BY_MODEL = "SELECT l FROM Laptop l " +
            "WHERE l.model = :model";
    public static final String MODEL = "model";
    public static final String LAPTOP_ID = "laptop_id";
    public static final String MANUFACTURER = "manufacturer";
    public static final String ALL_LAPTOP = "SELECT l FROM Laptop l";
    public static final String UNIT_NAME = "test-dmytro";
    public static String UPDATE =
            "UPDATE Laptop l SET l.model = :model, l.manufacturer = :manufacturer, l.releaseDate = :release_date, " +
                    "l.RAMCapacity = :RAM_Capacity, l.SSDCapacity = :SSD_Capacity, l.processor = :processor " +
                    "WHERE l.id = :laptop_id";


}
