package com.recap;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        // Create products
        Product product1 = new Product(1, "banana", "fruit", new BigDecimal("1.99"), 33);
        Product product2 = new Product(2, "bread", "baked foods", new BigDecimal("1.99"), 123);
        Product product3 = new Product(3, "milk", "dairy", new BigDecimal("1.99"), 35);
        Product product4 = new Product(4, "cereal", "pantry staples", new BigDecimal("1.99"), 22);
        Product product5 = new Product(5, "broccoli", "vegetable", new BigDecimal("1.99"), 176);
        Product product6 = new Product(6, "cheese", "dairy", new BigDecimal("1.99"), 79);
        Product product7 = new Product(7, "chicken", "poultry", new BigDecimal("1.99"), 399);

        // Create repositories
        ProductRepo productRepo = new ProductRepo();
        OrderListRepo orderRepo = new OrderListRepo();

        // Add products to the repository
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);
        productRepo.addProduct(product3);
        productRepo.addProduct(product4);
        productRepo.addProduct(product5);
        productRepo.addProduct(product6);
        productRepo.addProduct(product7);

        // Create ShopService
        ShopService shopService = new ShopService(productRepo, orderRepo);

        // Print all products
        System.out.println("PRODUCTS------------------------------");
        productRepo.getAllProducts();
        System.out.println("--------------------------------------");

        // Get a single product
        System.out.println("GET SINGLE PRODUCT--------------------");
        productRepo.getSingleProduct(product1);
        System.out.println("--------------------------------------");

        // Get product by name
        System.out.println("GET PRODUCT BY NAME-------------------");
        productRepo.getProductByName("banana");
        System.out.println("--------------------------------------");

        // Remove a product
        System.out.println("REMOVE PRODUCT------------------------");
        productRepo.removeProduct(product7);
        System.out.println("--------------------------------------");

        System.out.println("RE-ADD PRODUCT-------------------------");
        productRepo.addProduct(product7);
        productRepo.getAllProducts();
        System.out.println("--------------------------------------");

        // Place orders using ShopService
        System.out.println("PLACE ORDERS--------------------------");
        shopService.placeOrder("banana", 5); // Success
        shopService.placeOrder("bread", 200); // Insufficient stock
        shopService.placeOrder("unknown", 1); // Product not found
        System.out.println("--------------------------------------");

        // Print all orders
        System.out.println("ORDERS--------------------------------");
        orderRepo.getAllOrders();
        System.out.println("--------------------------------------");
    }
}
