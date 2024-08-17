package org.com.homeworks.sergii_khvostov.hw_04_08_2024.laptop_jpa.db_connection;

import lombok.Value;

@Value
public class Requests {

    public static String FACTORY_NAME = "test-laptopJPA";
    public static String SET_ID = "user_id";
    public static String SET_MODEL = "user_model";
    public static String SET_RELEASEDATE = "user_date";
    public static String SET_RAMSIZE = "user_ramSize";
    public static String SET_SSDCAPACITY = "user_ssdCapacity";
    public static String SET_PROCESSOR = "user_processor";

    public static String GET_BY_ID = "SELECT l FROM LaptopJPA l WHERE l.id = :user_id";

    public static String GET_ALL = "SELECT l FROM LaptopJPA l";

    public static String DELETE_BY_ID = "DELETE FROM LaptopJPA l WHERE l.id = :user_id";

    public static String DELETE_ALL = "DELETE FROM LaptopJPA";

    public static String UPDATE =
            "UPDATE LaptopJPA l SET l.model = :model, l.manufacturer = :manufacturer, l.releaseDate = :releaseDate, " +
                    "l.ramSize = :ramSize, l.ssdCapacity = :ssdCapacity WHERE l.id = :user_id";

    public static String GET_BY_MODEL = "FROM LaptopJPA l WHERE l.model =:user_model";

    public static String GET_BY_RELEASEDATE = "FROM LaptopJPA l WHERE l.releaseDate =:user_date";

    public static String GET_BY_RAM_AND_SSD = "FROM LaptopJPA l WHERE l.ramSize =:user_ramSize AND l.ssdCapacity =:user_ssdCapacity";

    public static String GET_BY_PROCESSOR = "FROM LaptopJPA l WHERE l.processor =:user_processor";

    public static String DELETE_BY_PROCESSOR = "DELETE FROM LaptopJPA l WHERE l.processor =:user_processor";

    public static String DELETE_BY_RAM_AND_SSD = "DELETE FROM LaptopJPA l WHERE l.ramSize =:user_ramSize AND l.ssdCapacity =:user_ssdCapacity";

}
