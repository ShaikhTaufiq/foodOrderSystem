package org.example;

import org.example.models.Item;
import org.example.service.FoodOrderService;

import java.util.Arrays;

public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }

    public static void main(String[] args) {
        FoodOrderService system = new FoodOrderService();

        // Adding restaurants
        system.addRestaurant("A2B", Arrays.asList(new Item("Idly", 40), new Item("Vada", 30), new Item("Dosa", 50)), 4);
        system.addRestaurant("Rasaganga", Arrays.asList(new Item("Idly", 45), new Item("Set Dosa", 60), new Item("Poori", 25)), 6);
        system.addRestaurant("Eat Fit", Arrays.asList(new Item("Idly", 30), new Item("Vada", 40)), 2);

        // Placing orders
        system.placeOrder(Arrays.asList("Idly", "Poori"));
        system.placeOrder(Arrays.asList("Idly", "Vada"));
        system.printRestaurantStats();

        // Placing orders
        system.placeOrder(Arrays.asList("Idly","Idly","Idly","Idly","Idly"));
        system.printRestaurantStats();

        // Fulfill orders
        system.completeOrder(1);
        system.printRestaurantStats();

        // Fulfill orders
        system.completeOrder(3);
        system.printRestaurantStats();

        // Change menu
        system.updateMenu("Eat Fit", Arrays.asList(new Item("Idly", 60), new Item("Vada", 40)));
        system.placeOrder(Arrays.asList("Idly"));
    }
}