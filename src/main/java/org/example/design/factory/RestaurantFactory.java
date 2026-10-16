package org.example.design.factory;

import org.example.models.Item;
import org.example.models.Restaurant;

import java.util.List;

public class RestaurantFactory {
    public static Restaurant createRestaurant(String name, int capacity, List<Item> menuItems) {
        return new Restaurant(name, capacity, menuItems);
    }
}
