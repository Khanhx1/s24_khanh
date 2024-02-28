package furama_resort.views;

import furama_resort.controllers.CustomerController;
import furama_resort.models.person.Customer;
import furama_resort.models.person.Employee;
import furama_resort.utils.exception.DateException;
import furama_resort.utils.exception.NumberException;
import furama_resort.utils.regex.person.CustomerRegex;

import java.util.List;
import java.util.Scanner;

public class CustomerManagement {
    private int choice;
    private Scanner scanner = new Scanner(System.in);
    private NumberException numberException = new NumberException();
    private CustomerRegex customerRegex = new CustomerRegex();
    private DateException dateException = new DateException();
    private CustomerController customerController = new CustomerController();


    public void manageCustomer() {
        Customer customer;
        List<Customer> customerList;
        String inputCode;
        Customer customerByCode;
        String choiceConfirm;
        int editPropertyChoice;
        String newValue;
        String findByName;
        List<Customer> listCustomerByName;
        do {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Delete customer");
            System.out.println("5. Search by name customer");
            System.out.println("6. Return main menu");
            choice = numberException.inputIntegerNumberException();
            switch (choice) {
                case 2:
                    customer = inputCustomer();
                    customerController.add(customer);
                    System.out.println("successfully");
                    break;
                case 1:
                    customerList = customerController.findAll();
                    for (Customer customer1: customerList) {
                        System.out.println(customer1);
                    }
                    break;
                case 4:
                    System.out.print("Enter customer's code you want to remove: ");
                    inputCode = scanner.nextLine();
                    customerByCode = customerController.findByCode(inputCode);
                    if (customerByCode != null) {
                        System.out.println("Employee that you want to remove: " + customerByCode);
                        System.out.println("Do you want to remove this? y for yes: ");
                        choiceConfirm = scanner.nextLine();
                        if (choiceConfirm.equals("y")) {
                            customerController.remove(inputCode);
                            System.out.println("successfully");
                        } else {
                            System.out.println("removing is cancel");
                        }
                    } else {
                        System.out.println("Customer's code is not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter customer's code you want to edit: ");
                    inputCode = scanner.nextLine();
                    customerByCode = customerController.findByCode(inputCode);
                    if (customerByCode != null) {
                        System.out.println("Customer that you want to edit: " + customerByCode);
                        do {
                            System.out.println("Which property do you want to edit:");
                            System.out.println("1. name" + "\n" + "2. dateOfBirth" + "\n" + "3. gender" + "\n" + "4. identificationCard" + "\n" + "5. phoneNumber" + "\n" + "6. email" + "\n" + "7. TypeOfCustomer" + "\n" + "8. Address" + "\n" + "9. return menu");
                            System.out.print("Enter your choice: ");
                            editPropertyChoice = numberException.inputIntegerNumberException();
                            if (editPropertyChoice != 3 && editPropertyChoice != 9 && editPropertyChoice !=7) {
                                System.out.print("Enter your new value: ");
                            }
                            if (editPropertyChoice == 9) {
                                continue;
                            }
                            newValue = checkInputEditProperty(editPropertyChoice);
                            System.out.println("Do you want to save this? y for yes: ");
                            choiceConfirm = scanner.nextLine();
                            if (choiceConfirm.equals("y")) {
                                customerController.edit(newValue, editPropertyChoice, inputCode);
                                System.out.println("successfully");
                            } else {
                                System.out.println("saving is cancel");
                            }
                        } while (editPropertyChoice != 9);
                    } else {
                        System.out.println("Employee's code is not found");
                    }
                    break;
                case 5:
                    System.out.print("Enter name do you want to find:");
                    findByName = scanner.nextLine();
                    listCustomerByName = customerController.findByName(findByName);
                    for (Customer customer1 : listCustomerByName) {
                        System.out.println(customer1);
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("invalid choice, try again");
            }
        } while (choice != 6);
    }


    public Customer inputCustomer() {
        String name;
        String dateOfBirth;
        int choiceGender;
        int count = 0;
        String gender = null;
        String identificationCard;
        String phoneNumber;
        String customerCode;
        String typeOfCustomer;
        int choiceClass;
        System.out.print("Enter new Name: ");
        do {
            name = scanner.nextLine();
            if (customerRegex.checkNameCustomerRegex(name)) {
                break;
            }
            System.out.print("invalid name, try again: ");
        } while (true);
        System.out.print("Enter new date of birth: ");
        do {
            dateOfBirth = scanner.nextLine();
            if (customerRegex.checkAgeCustomerRegex(dateOfBirth)) {
                if (dateException.checkAgeGreater18(dateOfBirth)) {
                    break;
                } else {
                    System.out.print("invalid date of birth, try again: ");
                }
            } else {
                System.out.print("invalid date of birth, try again: ");
            }
        } while (true);
        System.out.println("----Gender option----");
        System.out.println("1. Male" + "\n" + "2. Female");
        System.out.print("Enter new gender:");
        do {
            count = 0;
            choiceGender = Integer.parseInt(scanner.nextLine());
            switch (choiceGender) {
                case 1:
                    gender = "Male";
                    count++;
                    break;
                case 2:
                    gender = "Female";
                    count++;
                    break;
                default:
                    System.out.print("invalid choice, try again: ");
            }
        } while (count == 0);
        System.out.print("Enter new id card: ");
        do {
            identificationCard = scanner.nextLine();
            if (customerRegex.checkIdCardCustomerRegex(identificationCard)) {
                break;
            }
            System.out.print("Invalid id card, try again: ");
        } while (true);
        System.out.print("Enter new phone number: ");
        do {
            phoneNumber = scanner.nextLine();
            if (customerRegex.checkPhoneNumberCustomerRegex(phoneNumber)) {
                break;
            }
            System.out.println("Invalid phone number, try again: ");
        } while (true);
        System.out.print("Enter new email:");
        String email = scanner.nextLine();
        System.out.print("Enter new code:");
        do {
            customerCode = scanner.nextLine();
            if (customerRegex.checkCodeCustomerRegex(customerCode)) {
                break;
            }
            System.out.println("Invalid customer code, try again: ");
        } while (true);
        System.out.println("---(Type of customer)---");
        System.out.println("1. Diamond" + "\n" + "2. Platinum" + "\n" + "3. Gold" + "\n" + "4. Silver" + "\n" + "5. Member");
        System.out.print("Enter choice: ");
        do {
            typeOfCustomer = null;
            choiceClass = Integer.parseInt(scanner.nextLine());
            switch (choiceClass) {
                case 1:
                    typeOfCustomer = "Diamond";
                    break;
                case 2:
                    typeOfCustomer = "Platinum";
                    break;
                case 3:
                    typeOfCustomer = "Gold";
                    break;
                case 4:
                    typeOfCustomer = "Silver";
                    break;
                case 5:
                    typeOfCustomer = "Member";
                    break;
                default:
                    System.out.println("invalid choice, try again");
            }
        } while (typeOfCustomer == null);
        System.out.print("Enter new address:");
        String address = scanner.nextLine();
        Customer customer = new Customer(name, dateOfBirth, gender, identificationCard, phoneNumber, email, customerCode, typeOfCustomer, address);
        return customer;
    }
    public String checkInputEditProperty(int choice) {
        String newValue = null;
        boolean check = false;
        int choiceGender;
        int choiceClass;
        do {
            if (choice != 3 && choice != 7) {
                newValue = scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    check = customerRegex.checkNameCustomerRegex(newValue);
                    if (!check) {
                        System.out.println("invalid name, try again");
                    }
                    break;
                case 2:
                    if (customerRegex.checkAgeCustomerRegex(newValue)) {
                        if (dateException.checkAgeGreater18(newValue)) {
                            check = true;
                        } else {
                            check = false;
                        }
                    } else {
                        check = false;
                    }
                    if (!check) {
                        System.out.println("invalid date, try again");
                    }
                    break;
                case 3:
                    System.out.println("---oOo---");
                    System.out.println("1. Male" + "\n" + "2. Female");
                    System.out.print("choose gender: ");
                    choiceGender = Integer.parseInt(scanner.nextLine());
                    if (choiceGender == 1) {
                        newValue = "Male";
                        check = true;
                    } else if (choiceGender == 2) {
                        newValue = "Female";
                        check = true;
                    } else {
                        System.out.println("invalid choice, try again");
                        check = false;
                    }
                    break;
                case 4:
                    check = customerRegex.checkIdCardCustomerRegex(newValue);
                    if (!check) {
                        System.out.println("invalid id card, try again");
                    }
                    break;
                case 5:
                    check = customerRegex.checkPhoneNumberCustomerRegex(newValue);
                    if (!check) {
                        System.out.println("invalid phone number, try again");
                    }
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("---oOo---");
                    System.out.println("1. Diamond" + "\n" + "2. Platinum" + "\n" + "3. Gold" + "\n" + "4. Silver" + "\n" + "5. Member");
                    System.out.print("Enter choice: ");
                    choiceClass = Integer.parseInt(scanner.nextLine());
                    if(choiceClass == 1) {
                        newValue = "Diamond";
                        check = true;
                        break;
                    } else if (choiceClass == 2) {
                        newValue = "Platinum";
                        check = true;
                        break;
                    } else if (choiceClass == 3) {
                        newValue = "Gold";
                        check = true;
                        break;
                    } else if (choiceClass == 4) {
                        newValue = "Silver";
                        check = true;
                        break;
                    } else if (choiceClass == 5) {
                        newValue = "Member";
                        check = true;
                        break;
                    }
                    break;
                case 8:
                    break;
                default:
                    System.out.println("invalid choice, try again");
                    check = false;
            }
        } while (check == false);
        return newValue;
    }
}
