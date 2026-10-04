package com.store.service;

import com.store.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class ProductService {

    private List<Product> products = new ArrayList<>();

    public void loadProducts(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                // FIX: correct split for your file format
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                int stock = Integer.parseInt(parts[3].trim());

                Product p = new Product(id, name, price, stock);
                products.add(p);

                // DEBUG (you can remove later)
                System.out.println("Loaded: " + p);
            }

            System.out.println("TOTAL PRODUCTS LOADED: " + products.size());

        } catch (Exception e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }

    public List<Product> listAll() {
        return products;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(int id) {
        Product product = getProductById(id);
        if (product != null) {
            products.remove(product);
        }
    }

    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void updateStock(int id, int quantity) {
        Product p = getProductById(id);
        if (p != null) {
            p.setStock(quantity);
        }
    }

    public List<Product> searchByName(String keyword) {
        List<Product> results = new ArrayList<>();

        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(p);
            }
        }

        return results;
    }

    public List<Product> filterByPrice(double min, double max) {
        List<Product> filtered = new ArrayList<>();

        for (Product p : products) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                filtered.add(p);
            }
        }

        return filtered;
    }
}