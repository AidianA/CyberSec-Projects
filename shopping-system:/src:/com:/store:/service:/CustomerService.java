package com.store.service;
import com.store.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();
    public void loadCustomers(String filepath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String email = parts[2];

                Customer customer = new Customer(id, name, email);
                customers.add(customer);
            }
            br.close();
        
        } catch (Exception e) {
            System.out.println("Error loading customers.");
        }
    }
    public List<Customer> listAll() {
        return customers;
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void deleteCustomer(int id) {
        Customer customer = getCustomerById(id);

        if (customer != null) {
            customers.remove(customer);
        }
    }
    public Customer getCustomerById(int id){
        for(Customer c : customers) {

            if (c.getId() == id) {
            return c;
        }
    }
    return null;
    }
}