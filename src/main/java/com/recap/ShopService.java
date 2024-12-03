package com.recap;

import java.math.BigDecimal;
import java.util.UUID;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderListRepo orderListRepo;

    // Constructor
    public ShopService(ProductRepo productRepo, OrderListRepo orderListRepo) {
        this.productRepo = productRepo;
        this.orderListRepo = orderListRepo;
    }

    // Counter for generating simple IDs (UUID was overkill)
    private static int orderCounter = 1;

    // Generate short order ID
    private String generateOrderId() {
        return "ORDER-" + (orderCounter++);
    }

    // place order
    public void placeOrder(String productName, int quantity) {
        // 1. Find product
        Product product = productRepo.getProductByName(productName);
        if (product == null) {
            System.out.println("Error: Product " + productName + " not found.");
            return;
        }

        // 2. Check if stock
        if(product.quantity() < quantity) {
            System.out.println("Error: Product " + productName + " has insufficient stock. Only " + product.quantity() + " items remaining in stock.");
            return;
        }

        // 3. Calculate total cost
        BigDecimal itemPrice = product.price();
            // not sure which to use: BigDecimal.valueOf(double) or (new BigDecimal(quantity)
        BigDecimal totalPrice = itemPrice.multiply(BigDecimal.valueOf(quantity));

        // 4. Generate order number
        String orderId = generateOrderId();

        // 5. Update Stock
        productRepo.updateStock(product, product.quantity() - quantity);

        // 5. Create and add order
        Order order = new Order(orderId, productName, quantity, itemPrice, totalPrice );
        orderListRepo.addOrder(order);

        System.out.println("Order added successfully: " + order);
    }
}
