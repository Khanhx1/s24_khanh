package furama_resort.repositories.impl;

import furama_resort.models.person.Employee;
import furama_resort.repositories.IEmployeeRepository;
import furama_resort.utils.employee.EmployeeCSV;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private List<Employee> employeeList = new ArrayList<>();
    private EmployeeCSV employeeCSV = new EmployeeCSV();

    @Override
    public List<Employee> findAll() {
        return employeeCSV.readCSV();
    }

    @Override
    public void add(Employee employee) {
        if (!employeeCSV.readCSV().isEmpty()) {
            employeeList = employeeCSV.readCSV();
            employeeList.add(employee);
            String list = employeeCSV.convertListToStringCSV(employeeList);
            employeeCSV.writeListToCSV(list);
        } else {
            employeeList.add(employee);
            String list = employeeCSV.convertListToStringCSV(employeeList);
            employeeCSV.writeListToCSV(list);
        }
    }

    @Override
    public Employee findByCode(String inputCode) {
        employeeList = employeeCSV.readCSV();
        for (Employee employee : employeeList) {
            if (employee.getEmployeeCode().equals(inputCode)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void remove(String inputCode) {
        employeeList = employeeCSV.readCSV();
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getEmployeeCode().equals(inputCode)){
                employeeList.remove(employeeList.get(i));
                break;
            }
        }
        String list = employeeCSV.convertListToStringCSV(employeeList);
        employeeCSV.writeListToCSV(list);
    }

    @Override
    public void edit(String newValue, int editPropertyChoice, String inputCode) {
        employeeList = employeeCSV.readCSV();
        Employee employee1 = null;
        for (Employee employee: employeeList) {
            if(employee.getEmployeeCode().equals(inputCode)){
                employee1 = employee;
                break;
            }
        }
        switch (editPropertyChoice) {
            case 1:
                employee1.setName(newValue);
                break;
            case 2:
                employee1.setDateOfBirth(newValue);
                break;
            case 3:
                employee1.setGender(newValue);
                break;
            case 4:
                employee1.setIdentificationCard(newValue);
                break;
            case 5:
                employee1.setPhoneNumber(newValue);
                break;
            case 6:
                employee1.setEmail(newValue);
                break;
            case 7:
                employee1.setEducation(newValue);
                break;
            case 8:
                employee1.setPosition(newValue);
                break;
            case 9:
                employee1.setSalary(Long.valueOf(newValue));
                break;
        }
        String list = employeeCSV.convertListToStringCSV(employeeList);
        employeeCSV.writeListToCSV(list);
    }

    @Override
    public List<Employee> findByName(String findByName) {
        List<Employee> listByName = new ArrayList<>();
        employeeList = employeeCSV.readCSV();
        for (Employee employee: employeeList) {
            if(employee.getName().equals(findByName)){
                listByName.add(employee);
            }
        }
        return listByName;
    }
}
