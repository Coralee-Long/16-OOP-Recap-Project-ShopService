package com.recap;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo {

    // order list
    private final List<Order> orders;

    // constructor
    public OrderListRepo() {
        this.orders = new ArrayList<>();
    }

    // get all orders
    public List<Order> getAllOrders() {
        System.out.println("Getting all orders: " + orders);
        for (Order order : orders) {
            System.out.println("orderId: " + order.orderId() +
                    ", item: " + order.item() +
                    ", quantity: " + order.quantity() +
                    ", itemPrice: " + order.itemPrice() +
                    ", totalPrice: " + order.totalPrice());
        }
        return new ArrayList<>(orders); // ensure immutability
    }

    // get single order
    public Order getSingleOrder(Order order) {
        if(!orders.contains(order)) {
            System.out.println("Order: " + order + ", not found");
            return null;
        }
        System.out.println("Order Found: " + order);
        return order;
    }

    // add order
    public void addOrder(Order order) {
        orders.add(order);
    }

    // remove order from orders list
    public void removeOrder(Order order) {
        if(!orders.contains(order)) {
            System.out.println("Order removal unsuccessful: " + order.item() + ", not found.");
            return;
        }
        System.out.println(order.item() + " was removed successfully.");
        orders.remove(order);

    }
}
