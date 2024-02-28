package furama_resort.services;

import furama_resort.models.person.Employee;

import java.util.List;

public interface IEmployeeService extends IService<Employee>{

    void edit(String newValue, int editPropertyChoice, String inputCode);

    List<Employee> findByName(String findByName);
}
