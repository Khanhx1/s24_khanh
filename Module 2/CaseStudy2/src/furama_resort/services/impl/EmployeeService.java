package furama_resort.services.impl;

import furama_resort.models.person.Employee;
import furama_resort.repositories.IEmployeeRepository;
import furama_resort.repositories.impl.EmployeeRepository;
import furama_resort.services.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public Employee findByCode(String inputCode) {
        return employeeRepository.findByCode(inputCode);
    }

    @Override
    public void remove(String inputCode) {
        employeeRepository.remove(inputCode);
    }

    @Override
    public void edit(String newValue, int editPropertyChoice, String inputCode) {
        employeeRepository.edit(newValue, editPropertyChoice, inputCode);
    }

    @Override
    public List<Employee> findByName(String findByName) {
        return employeeRepository.findByName(findByName);
    }
}
