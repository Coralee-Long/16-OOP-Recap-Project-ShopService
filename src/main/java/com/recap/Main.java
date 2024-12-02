package com.recap;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // create products
        Product product1 = new Product(1, "banana", "fruit", new BigDecimal("1.99"), 33);
        Product product2 = new Product(2, "bread", "baked foods", new BigDecimal("1.99"), 123);
        Product product3 = new Product(3, "milk", "dairy", new BigDecimal("1.99"), 35);
        Product product4 = new Product(4, "cereal", "pantry staples", new BigDecimal("1.99"), 22);
        Product product5 = new Product(5, "broccoli", "vegetable", new BigDecimal("1.99"), 176);
        Product product6 = new Product(6, "cheese", "dairy", new BigDecimal("1.99"), 79);
        Product product7 = new Product(7, "chicken", "poultry", new BigDecimal("1.99"), 399);

        // create productRepo
        ProductRepo products = new ProductRepo();

        // Add products to repo
        products.addProduct(product1);
        products.addProduct(product2);
        products.addProduct(product3);
        products.addProduct(product4);
        products.addProduct(product5);
        products.addProduct(product6);
        products.addProduct(product7);

        // All printing is done in the functions for my sanity
        products.getAllProducts();
        products.getSingleProduct(product1);
        products.removeProduct(product7);
        products.getAllProducts(); // test product was removed




    }
}