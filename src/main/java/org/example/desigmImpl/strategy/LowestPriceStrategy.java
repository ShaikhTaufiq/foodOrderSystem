package org.example.desigmImpl.strategy;

import org.example.models.Restaurant;
import org.example.design.strategy.RestaurantSelectionStrategy;

import java.util.List;

public class LowestPriceStrategy implements RestaurantSelectionStrategy {
    @Override
    public Restaurant selectRestaurant(String item, List<Restaurant> restaurants) {
        Restaurant bestRestaurant = null;
        double lowestPrice = Integer.MAX_VALUE;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.hasCapacity() && restaurant.hasItem(item)) {
                double price = restaurant.getPriceForItem(item);
                if (price < lowestPrice) {
                    lowestPrice = price;
                    bestRestaurant = restaurant;
                }
            }
        }
        return bestRestaurant;
    }
}
