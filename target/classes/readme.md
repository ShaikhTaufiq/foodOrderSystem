Food ordering system
Description:
Implement an online food ordering system. Below are the expected features of the system.

Features:
This system has tie-ups with restaurants, each with a menu with all the items at their prices.
Each restaurant has a maximum processing capacity(food preparation and dispatch) of items at any given time. It will not accept any further item requests until items in processing are completed.
Each restaurant takes some time to prepare and dispatch food. Once the item is fulfilled the system gets the notification of it which adds back to the processing capacity of that restaurant.
One or multiple restaurants can be selected based on the restaurant selection strategy.
Order is accepted from customers only if all the items can be fulfilled by one or more restaurants.

Requirements:
Onboard new restaurant with its menu and item processing capacity. The menu should be reflected in the food ordering system.
A restaurant should be able to change its menu.
Customers should be able to place an order by giving items. We can assume that each item will be of only 1 quantity.
Restaurants should be selected based on the lowest price offered by the restaurant for that item.
The system should be able to keep track of all items served by each restaurant, and the system should be aware of the remaining capacity of each restaurant at a given time.
Once the order is fulfilled by the restaurant, the capacity should be replenished for the given restaurant.

Other Details:
Do not use any database or NoSQL store, use an in-memory data structure.
Do not create any UI for the application.
Write a driver class for demo purposes. Which will execute all the commands in one place in the code and have test cases.
Expectations:
Make sure that you have working and demonstrable code through test cases.
Make sure that the code is functionally correct.
Work on the expected output first and then add good-to-have features of your own.
Code should be modular, readable, and extensible.
Separation of concern should be addressed.
The code should easily accommodate new requirements with minimal changes.
The code should be easily testable.
Wherever required, concurrent requests should be handled appropriately.

Test-cases:
Below are the sample driver commands that can be demonstrated. This is for the understanding purpose, it does not reflect exact function calls.

1. add_restaurant("A2B", [Idly for 40Rs, Vada for 30Rs, Paper Plain Dosa for 50Rs], 4)
2. add_restaurant("Rasaganga", [Idly for 45Rs, Set Dosa for 60Rs, Poori for 25Rs], 6)
3. add_restaurant("Eat Fit", [Idly 30Rs, Vada for 40Rs], 2)
4. order(["Idly", "Poori"])
output: Order Id#1: Ordered from "Eat Fit" & "Rasaganga"
5. order(["Idly", "Vada"])
output: Order Id#2 : Ordered from "Eat Fit" & "A2B"
6. Print system stats:
output (Restaurant name and current processing power):
A2B: 3
Rasaganga: 5
Eat Fit: 0
7. order(["Idly"])
output: Ordered from "A2B"   ("Eat Fit" was not selected since there was no further capacity left)
fulfilled_item_for_restaurant("Order Id#1")
8. Print system stats:
output (Restaurant name and current processing power):
A2B: 2
Rasaganga: 6
Eat Fit: 1
9. fulfilled_item_for_restaurant("#2")
10. change_menu("Eat Fit", [Idly 60Rs, Vada for 40Rs], 2)
11. order(["Idly"])
output: Ordered from "A2B"
