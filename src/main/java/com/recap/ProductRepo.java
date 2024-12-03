package com.recap;

import java.math.BigDecimal;
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
        System.out.println("Getting all products: ");
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

    // Find product by name
    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.name().equalsIgnoreCase(name)) { // Case-insensitive match
                return product; // Return the found product
            }
        }
        System.out.println("Product with name: " + name + " not found.");
        return null; // Return null if no product is found
    }


    // add product
    public void addProduct(Product product) {
        if (products.contains(product)) {
            System.out.println("Product already exists: " + product.name());
            return;
        }
        products.add(product);
        System.out.println(product.name() + " was added successfully.");
    }

    // remove product from products list
    public void removeProduct(Product product) {
        if(!products.contains(product)) {
            System.out.println("Product removal unsuccessful: " + product.name() + ", not found.");
        return;
        }
        System.out.println("Product :" + product.name() + " was removed successfully.");
        products.remove(product);

    }

    // get product item price
//    public BigDecimal getItemPrice(Product product) {
//       if(product == null) {
//           System.out.println("Error: Product not found.");
//           return new BigDecimal("0.00");
//       }
//       if(product.price() == null) {
//           System.out.println("Error: " + product.name() + " price not found.");
//           return new BigDecimal("0.00");
//       }
//        return product.price();
//    }

    // update product stock
    public void updateStock(Product product, int newQuantity) {
        // use indexOf() here
        int index = products.indexOf(product);
        if (index != -1) {
            products.set(index, new Product(product.id(), product.name(), product.category(), product.price(), newQuantity));
        }
    }
}
