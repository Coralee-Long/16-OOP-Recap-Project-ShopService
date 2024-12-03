package com.recap;

import java.util.List;

public interface OrderRepoInterface {
    void addOrder(Order order);
    void removeOrder(Order order);
    Order getSingleOrder(Order order);
    List<Order> getAllOrders();
}
