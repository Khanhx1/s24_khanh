package furama_resort.utils.employee;

import furama_resort.models.person.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerCSV {
    private final String PATH_FILE = "D:\\4K\\codeG du an ngoai\\CaseStudy2\\src\\furama_resort\\data\\customer.csv";

    public List<Customer> readCSV() {
        List<Customer> customerList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(PATH_FILE);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] temp;
            Customer customer;
            String name;
            String dateOfBirth;
            String gender;
            String identificationCard;
            String phoneNumber;
            String email;
            String customerCode;
            String typeOfCustomer;
            String address;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                name = temp[0];
                dateOfBirth = temp[1];
                gender = temp[2];
                identificationCard = temp[3];
                phoneNumber = temp[4];
                email = temp[5];
                customerCode = temp[6];
                typeOfCustomer = temp[7];
                address = temp[8];

                customer = new Customer(name, dateOfBirth, gender, identificationCard, phoneNumber, email, customerCode, typeOfCustomer, address);
                customerList.add(customer);
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
        return customerList;
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
    public String convertListToStringCSV(List<Customer> customerList){
        String content = "";
        for (Customer Customer: customerList) {
            content += Customer.getName() + "," + Customer.getDateOfBirth() + "," + Customer.getGender() + "," + Customer.getIdentificationCard() + "," + Customer.getPhoneNumber() + "," + Customer.getEmail() + "," + Customer.getCustomerCode() + "," + Customer.getTypeOfCustomer() + "," + Customer.getAddress() + "\n";
        }
        return content;
    }
}
