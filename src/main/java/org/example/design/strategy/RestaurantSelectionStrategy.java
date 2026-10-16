package org.example.design.strategy;

import org.example.models.Restaurant;

import java.util.List;

public interface RestaurantSelectionStrategy {
    Restaurant selectRestaurant(String item, List<Restaurant> restaurants);
}
