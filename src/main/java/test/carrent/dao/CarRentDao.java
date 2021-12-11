package test.carrent.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentDao {

    public static Map<String, Integer> inStockMap = new ConcurrentHashMap<>();

    static {
        inStockMap.put("BMW 650", 2);
        inStockMap.put("Toyota Camry", 2);
    }
}