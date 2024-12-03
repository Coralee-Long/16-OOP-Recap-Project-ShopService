package com.recap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepoInterface {

    // Create Map
   private final Map<String, Order> orders;

    // Constructor
    public OrderMapRepo() {
        this.orders = new HashMap<>(); // Initialize here
    }

    // get all orders (don't understand the stream thing
    @Override
        public List<Order> getAllOrders() {
            System.out.println("Getting all orders:");
            List<Order> orderList = new ArrayList<>();
            for (Order order : orders.values()) {
                System.out.println("orderId: " + order.orderId() +
                        ", item: " + order.item() +
                        ", quantity: " + order.quantity() +
                        ", itemPrice: " + order.itemPrice() +
                        ", totalPrice: " + order.totalPrice());
                orderList.add(order);
            }
            return orderList;
        }

        // get single order
    @Override
    public Order getSingleOrder(Order order) {
        Order foundOrder = orders.get(order.orderId());
        if (foundOrder == null) {
            System.out.println("Order with ID " + order.orderId() + " not found.");
            return null;
        }
        System.out.println("Order Found: " + foundOrder);
        return foundOrder;
    }

    // add order
    @Override
    public void addOrder(Order order) {
    // List -> orders.add(); Map -> orders.put()
        orders.put(order.orderId(), order);
        System.out.println("Order added: " + order);
    }

    // remove order
    @Override
    public void removeOrder(Order order) {
        // Only remove once
        if (orders.remove(order.orderId()) == null) {
            System.out.println("Order removal unsuccessful: " + order.item() + ", not found.");
        } else {
            System.out.println(order.item() + " was removed successfully.");
        }
    }
}
