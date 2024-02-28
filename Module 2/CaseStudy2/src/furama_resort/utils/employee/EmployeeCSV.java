package furama_resort.utils.employee;

import furama_resort.models.person.Employee;

import java.io.*;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCSV {
    private final String PATH_FILE = "D:\\4K\\codeG du an ngoai\\CaseStudy2\\src\\furama_resort\\data\\employee.csv";

    public List<Employee> readCSV() {
        List<Employee> employeeList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(PATH_FILE);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] temp;
            Employee employee;
            String name;
            String dateOfBirth;
            String gender;
            String identificationCard;
            String phoneNumber;
            String email;
            String employeeCode;
            String education;
            String position;
            Long salary;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                name = temp[0];
                dateOfBirth = temp[1];
                gender = temp[2];
                identificationCard = temp[3];
                phoneNumber = temp[4];
                email = temp[5];
                employeeCode = temp[6];
                education = temp[7];
                position = temp[8];
                salary = Long.valueOf(temp[9]);
                employee = new Employee(name, dateOfBirth, gender, identificationCard, phoneNumber, email, employeeCode, education, position, salary);
                employeeList.add(employee);
            }
        } catch (IOException e) {
            System.out.println("Path of file is invalid");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Error closing bufferReader");
                }
            }
        }
        return employeeList;
    }

    public void writeListToCSV(String list) {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(PATH_FILE, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(list);
        } catch (IOException e) {
            System.out.println("Path of file is invalid");
        } finally {
            if(bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Error closing bufferWriter");
                }
            }
        }
    }
    public String convertListToStringCSV(List<Employee> employeeList){
        String content = "";
        for (Employee employee: employeeList) {
            content += employee.getName() + "," + employee.getDateOfBirth() + "," + employee.getGender() + "," + employee.getIdentificationCard() + "," + employee.getPhoneNumber() + "," + employee.getEmail() + "," + employee.getEmployeeCode() + "," + employee.getEducation() + "," + employee.getPosition() + "," + employee.getSalary() + "\n";
        }
        return content;
    }
}
