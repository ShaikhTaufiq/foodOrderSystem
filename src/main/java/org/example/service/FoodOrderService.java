package org.example.service;

import org.example.desigmImpl.strategy.LowestPriceStrategy;
import org.example.design.factory.RestaurantFactory;
import org.example.design.strategy.RestaurantSelectionStrategy;
import org.example.models.Item;
import org.example.models.Order;
import org.example.models.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FoodOrderService {
    private final List<Restaurant> restaurants;
    private final List<Order> orders;
    private RestaurantSelectionStrategy selectionStrategy;

    public FoodOrderService() {
        this.restaurants = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.selectionStrategy = new LowestPriceStrategy();
    }

    public void setSelectionStrategy(RestaurantSelectionStrategy strategy) {
        this.selectionStrategy = strategy;
    }

    public void addRestaurant(String name, List<Item> menuItems, int capacity) {
        restaurants.add(RestaurantFactory.createRestaurant(name, capacity, menuItems));
    }

    public void updateMenu(String restaurantName, List<Item> items) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(restaurantName)) {
                restaurant.updateMenu(items);
                return;
            }
        }
    }

    //update capacity for restaurant;

    public Order placeOrder(List<String> items) {
        Order order = new Order(items);
        for (String item : items) {
            Restaurant selectedRestaurant = selectionStrategy.selectRestaurant(item, restaurants);
            if (selectedRestaurant == null) {
                System.out.println("Order cannot be fulfilled " + item);
                return null;
            }
            selectedRestaurant.processOrder();
            List<Restaurant> list = order.getItemRestaurantMap().getOrDefault(item, new ArrayList<>());
            list.add(selectedRestaurant);
            order.assignRestaurant(item, list);
        }
        orders.add(order);
        System.out.println("Order placed with Id " + order.getOrderId());
        for (Map.Entry<String, List<Restaurant>> entry : order.getItemRestaurantMap().entrySet()){
            System.out.print("Key = " + entry.getKey() +
                    ", Value = " );
            entry.getValue().stream().forEach(r-> System.out.print(r.getName() + " "));
        }
        System.out.println();
        return order;
    }

    public void completeOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                for (List<Restaurant> restaurants : order.getItemRestaurantMap().values()) {
                    restaurants.forEach(r-> r.replenishCapacity());
                }
                System.out.println("Order Id " + orderId + " fulfilled.");
                return;
            }
        }
        System.out.println("Order Id " + orderId + " not found.");
    }

    public void printRestaurantStats() {
        System.out.println("Restaurant Statistics:");
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getName() + ": " + restaurant.getCurrentCapacity());
        }
    }

}
