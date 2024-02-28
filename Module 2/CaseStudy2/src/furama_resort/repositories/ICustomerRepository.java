package furama_resort.repositories;

import furama_resort.models.person.Customer;

import java.util.List;

public interface ICustomerRepository extends IRepository{
    void add(Customer customer);

    List<Customer> findAll();

    Customer findByCode(String inputCode);

    void remove(String inputCode);

    void edit(String newValue, int editPropertyChoice, String inputCode);

    List<Customer> findByName(String findByName);
}
