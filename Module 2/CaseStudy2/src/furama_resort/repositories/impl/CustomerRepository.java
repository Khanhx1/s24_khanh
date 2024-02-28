package furama_resort.repositories.impl;

import furama_resort.models.person.Customer;
import furama_resort.models.person.Employee;
import furama_resort.repositories.ICustomerRepository;
import furama_resort.utils.employee.CustomerCSV;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private List<Customer> customerList = new ArrayList<>();
    private CustomerCSV customerCSV = new CustomerCSV();

    @Override
    public void add(Customer customer) {
        customerList = customerCSV.readCSV();
        customerList.add(customer);
        String value = customerCSV.convertListToStringCSV(customerList);
        customerCSV.writeListToCSV(value);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList1 = customerCSV.readCSV();
        return customerList1;
    }

    @Override
    public Customer findByCode(String inputCode) {
        customerList = customerCSV.readCSV();
        for (Customer customer : customerList) {
            if(customer.getCustomerCode().equals(inputCode)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void remove(String inputCode) {
        customerList = customerCSV.readCSV();
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getCustomerCode().equals(inputCode)){
                customerList.remove(customerList.get(i));
                break;
            }
        }
        String value = customerCSV.convertListToStringCSV(customerList);
        customerCSV.writeListToCSV(value);
    }

    @Override
    public void edit(String newValue, int editPropertyChoice, String inputCode) {
        customerList = customerCSV.readCSV();
        Customer customer = null;
        for (Customer customer1: customerList) {
            if(customer1.getCustomerCode().equals(inputCode)){
                customer = customer1;
                break;
            }
        }
        switch (editPropertyChoice) {
            case 1:
                customer.setName(newValue);
                break;
            case 2:
                customer.setDateOfBirth(newValue);
                break;
            case 3:
                customer.setGender(newValue);
                break;
            case 4:
                customer.setIdentificationCard(newValue);
                break;
            case 5:
                customer.setPhoneNumber(newValue);
                break;
            case 6:
                customer.setEmail(newValue);
                break;
            case 7:
                customer.setTypeOfCustomer(newValue);
                break;
            case 8:
                customer.setAddress(newValue);
                break;
        }
        String list = customerCSV.convertListToStringCSV(customerList);
        customerCSV.writeListToCSV(list);
    }

    @Override
    public List<Customer> findByName(String findByName) {
        List<Customer> listByName = new ArrayList<>();
        customerList = customerCSV.readCSV();
        for (Customer customer: customerList) {
            if(customer.getName().equals(findByName)){
                listByName.add(customer);
            }
        }
        return listByName;
    }
}
