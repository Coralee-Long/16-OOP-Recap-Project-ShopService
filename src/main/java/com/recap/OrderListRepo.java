package com.recap;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepoInterface {

    // order list
    private final List<Order> orders;

    // constructor
    public OrderListRepo() {
        this.orders = new ArrayList<>();
    }

    // Add an already-created order
    @Override
    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Order added: " + order);
    }

    // get all orders
    @Override
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
    @Override
    public Order getSingleOrder(Order order) {
        if(!orders.contains(order)) {
            System.out.println("Order: " + order + ", not found");
            return null;
        }
        System.out.println("Order Found: " + order);
        return order;
    }

    // remove order from orders list
    @Override
    public void removeOrder(Order order) {
        if(!orders.contains(order)) {
            System.out.println("Order removal unsuccessful: " + order.item() + ", not found.");
            return;
        }
        System.out.println(order.item() + " was removed successfully.");
        orders.remove(order);
    }
}
