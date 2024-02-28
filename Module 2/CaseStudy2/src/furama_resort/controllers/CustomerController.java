package furama_resort.controllers;

import furama_resort.models.person.Customer;
import furama_resort.services.ICustomerService;
import furama_resort.services.impl.CustomerService;

import java.util.List;

public class CustomerController {
    private ICustomerService customerService = new CustomerService();

    public void add(Customer customer) {
        customerService.add(customer);
    }

    public List<Customer> findAll() {
        return customerService.findAll();
    }

    public Customer findByCode(String inputCode) {
        return customerService.findByCode(inputCode);
    }

    public void remove(String inputCode) {
        customerService.remove(inputCode);
    }

    public void edit(String newValue, int editPropertyChoice, String inputCode) {
        customerService.edit(newValue, editPropertyChoice, inputCode);
    }

    public List<Customer> findByName(String findByName) {
        return customerService.findByName(findByName);
    }
}
