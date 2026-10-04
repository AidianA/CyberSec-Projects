package com.store.service;

import com.store.model.*;
import java.util.*;

public class OrderService {

    private List<Order> orders = new ArrayList<>();
    private ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public void addToCart(Customer customer, int productId, int quantity) {

        if (customer == null) return;

        Product product = productService.getProductById(productId);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        Order order = findOrCreateOrder(customer);
        order.addProduct(product, quantity);
    }

    public void checkout(Customer customer) {

        if (customer == null) {
            System.out.println("Invalid customer.");
            return;
        }

        Order order = findOrCreateOrder(customer);

        System.out.println("Checkout for: " + customer.getName());
        System.out.println(order);
    }

    public List<Order> listOrders() {
        return orders;
    }

    private Order findOrCreateOrder(Customer customer) {

        for (Order o : orders) {
            if (o.getCustomer().getId() == customer.getId()) {
                return o;
            }
        }

        Order newOrder = new Order(customer);
        orders.add(newOrder);
        return newOrder;
    }
}