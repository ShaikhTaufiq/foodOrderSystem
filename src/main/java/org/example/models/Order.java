package org.example.models;

import org.example.models.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final int orderId;
    private final List<String> items;
    private final Map<String, List<Restaurant>> itemRestaurantMap;

    public Order(List<String> items) {
        this.orderId = idGenerator.getAndIncrement();
        this.items = items;
        this.itemRestaurantMap = new HashMap<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public List<String> getItems() {
        return items;
    }

    public void assignRestaurant(String item, List<Restaurant> restaurants) {
        itemRestaurantMap.put(item, restaurants);
    }

    public Map<String, List<Restaurant>> getItemRestaurantMap() {
        return itemRestaurantMap;
    }
}

