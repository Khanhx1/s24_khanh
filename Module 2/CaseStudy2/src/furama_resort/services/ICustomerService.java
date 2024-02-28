package furama_resort.services;

import furama_resort.models.person.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer> {
    void edit(String newValue, int editPropertyChoice, String inputCode);

    List<Customer> findByName(String findByName);
}
