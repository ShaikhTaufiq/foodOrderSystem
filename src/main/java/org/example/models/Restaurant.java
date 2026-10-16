package org.example.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private final String name;
    private final int maxCapacity;
    private int currentCapacity;
    private final Map<String, Item> menu;

    public Restaurant(String name, int maxCapacity, List<Item> menuItems) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = maxCapacity;
        this.menu = new HashMap<>();
        for (Item item : menuItems) {
            this.menu.put(item.getName(), item);
        }
    }

    public String getName() {
        return name;
    }

    public boolean hasItem(String itemName) {
        return menu.containsKey(itemName);
    }

    public double getPriceForItem(String itemName) {
        return menu.get(itemName).getPrice();
    }

    public boolean hasCapacity() {
        return currentCapacity > 0;
    }

    public void processOrder() {
        if (currentCapacity > 0) {
            currentCapacity--;
        } else {
            throw new IllegalStateException("No capacity available");
        }
    }

    public void replenishCapacity() {
        if (currentCapacity < maxCapacity) {
            currentCapacity++;
        }
    }

    public void updateMenu(List<Item> items) {
        for (Item item : items) {
            menu.put(item.getName(), item);
        }
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }
}
