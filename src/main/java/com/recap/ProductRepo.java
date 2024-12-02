package com.recap;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    // product list
    private final List<Product> products;

    // constructor
    public ProductRepo() {
        this.products = new ArrayList<>();
    }

    // get all products
    public List<Product> getAllProducts() {
        System.out.println("Getting all products: " + products);
        for (Product product : products) {
            System.out.println("ID: " + product.id() +
                    ", Name: " + product.name() +
                    ", Category: " + product.category() +
                    ", Price: " + product.price() +
                    ", Quantity: " + product.quantity());
        }
        return new ArrayList<>(products); // ensure immutability
    }

    // get single product
    public Product getSingleProduct(Product product) {
            if(!products.contains(product)) {
                System.out.println("Product: " + product + ", not found");
                return null;
            }
        System.out.println("Product Found: " + product);
        return product;
    }

    // add product
    public void addProduct(Product product) {
        products.add(product);
    }

    // remove product from products list
    public void removeProduct(Product product) {
        if(!products.contains(product)) {
            System.out.println("Product removal unsuccessful: " + product.name() + ", not found.");
        return;
        }
        System.out.println(product.name() + " was removed successfully.");
        products.remove(product);

    }
}
