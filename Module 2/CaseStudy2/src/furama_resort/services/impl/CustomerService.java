package furama_resort.services.impl;

import furama_resort.models.person.Customer;
import furama_resort.repositories.ICustomerRepository;
import furama_resort.repositories.impl.CustomerRepository;
import furama_resort.services.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void add(Customer customer) {
customerRepository.add(customer);
    }

    @Override
    public Customer findByCode(String inputCode) {
        return customerRepository.findByCode(inputCode);
    }

    @Override
    public void remove(String inputCode) {
        customerRepository.remove(inputCode);
    }

    @Override
    public void edit(String newValue, int editPropertyChoice, String inputCode) {
        customerRepository.edit(newValue, editPropertyChoice, inputCode);
    }

    @Override
    public List<Customer> findByName(String findByName) {
        return customerRepository.findByName(findByName);
    }
}
