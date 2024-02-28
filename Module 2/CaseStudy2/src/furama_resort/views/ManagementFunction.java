package furama_resort.views;

import furama_resort.controllers.EmployeeController;
import furama_resort.models.person.Employee;
import furama_resort.utils.exception.DateException;
import furama_resort.utils.exception.NumberException;
import furama_resort.utils.regex.person.EmployeeRegex;

import java.util.List;
import java.util.Scanner;

public class ManagementFunction {
    private int choice;
    private Scanner scanner = new Scanner(System.in);
    private NumberException numberException = new NumberException();
    private EmployeeController employeeController = new EmployeeController();
    private EmployeeRegex employeeRegex = new EmployeeRegex();
    private DateException dateException = new DateException();

    public void manageEmployee() {
        List<Employee> employeeList;
        String inputCode;
        Employee newEmployee;
        Employee employeeByCode;
        String choiceConfirm;
        int editPropertyChoice;
        String newValue;
        String findByName;
        List<Employee> listEmployeeByName;
        do {
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Search by name employee");
            System.out.println("6. Return main menu");
            System.out.println("----------Enter your choice----------");
            choice = numberException.inputIntegerNumberException();
            switch (choice) {
                case 1:
                    employeeList = employeeController.findAll();
                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    break;
                case 2:
                    newEmployee = inputNewEmployee();
                    System.out.println("Do you want to save? y for yes: ");
                    choiceConfirm = scanner.nextLine();
                    if (choiceConfirm.equals("y")) {
                        employeeController.add(newEmployee);
                        System.out.println("successfully");
                    } else {
                        System.out.println("Saving is cancel");
                    }
                    break;
                case 4:
                    System.out.print("Enter employee's code you want to remove: ");
                    inputCode = scanner.nextLine();
                    employeeByCode = employeeController.findByCode(inputCode);
                    if (employeeByCode != null) {
                        System.out.println("Employee that you want to remove: " + employeeByCode);
                        System.out.println("Do you want to remove this? y for yes: ");
                        choiceConfirm = scanner.nextLine();
                        if (choiceConfirm.equals("y")) {
                            employeeController.remove(inputCode);
                            System.out.println("successfully");
                        } else {
                            System.out.println("removing is cancel");
                        }
                    } else {
                        System.out.println("Employee's code is not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter employee's code you want to edit: ");
                    inputCode = scanner.nextLine();
                    employeeByCode = employeeController.findByCode(inputCode);
                    if (employeeByCode != null) {
                        System.out.println("Employee that you want to edit: " + employeeByCode);
                        do {
                            System.out.println("Which property do you want to edit:");
                            System.out.println("1. name" + "\n" + "2. dateOfBirth" + "\n" + "3. gender" + "\n" + "4. identificationCard" + "\n" + "5. phoneNumber" + "\n" + "6. email" + "\n" + "7. education" + "\n" + "8. position" + "\n" + "9. salary" + "\n" + "10. return menu");
                            System.out.print("Enter your choice: ");
                            editPropertyChoice = numberException.inputIntegerNumberException();
                            if (editPropertyChoice != 3 && editPropertyChoice != 10) {
                                System.out.print("Enter your new value: ");
                            }
                            if (editPropertyChoice == 10) {
                                continue;
                            }
                            newValue = checkInputEditProperty(editPropertyChoice);
                            System.out.println("Do you want to save this? y for yes: ");
                            choiceConfirm = scanner.nextLine();
                            if (choiceConfirm.equals("y")) {
                                employeeController.edit(newValue, editPropertyChoice, inputCode);
                                System.out.println("successfully");
                            } else {
                                System.out.println("saving is cancel");
                            }
                        } while (editPropertyChoice != 10);
                    } else {
                        System.out.println("Employee's code is not found");
                    }
                    break;
                case 5:
                    System.out.print("Enter name do you want to find:");
                    findByName = scanner.nextLine();
                   listEmployeeByName = employeeController.findByName(findByName);
                   for (Employee employee : listEmployeeByName) {
                       System.out.println(employee);
                   }
                   break;
                case 6:
                    break;
                default:
                    System.out.println("invalid choice, try again");
            }
        } while (choice != 6);
    }

    public void manageCustomer() {
        do {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Delete customer");
            System.out.println("5. Search by name customer");
            System.out.println("6. Return main menu");
            choice = numberException.inputIntegerNumberException();
        } while (choice != 6);
    }

    public void manageFacility() {
        do {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Delete facility");
            System.out.println("5. Return main menu");
            choice = numberException.inputIntegerNumberException();
        } while (choice != 5);
    }

    public void manageBooking() {
        do {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            choice = numberException.inputIntegerNumberException();
        } while (choice != 6);
    }

    public void managePromotion() {
        do {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            choice = numberException.inputIntegerNumberException();
        } while (choice != 3);
    }

    public Employee inputNewEmployee() {
        int choiceGender;
        String gender;
        String dateOfBirth;
        String identificationCard;
        String phoneNumber;
        Long salary;
        String stringSalary;
        String name;
        String employeeCode;
        System.out.print("Enter your new name: ");
        do {
            name = scanner.nextLine();
            if (employeeRegex.checkNameEmployeeRegex(name)) {
                break;
            }
            System.out.print("invalid name, please try again: ");
        } while (true);
        System.out.print("Enter your date of birth: ");
        do {
            dateOfBirth = scanner.nextLine();
            if (employeeRegex.checkAgeEmployeeRegex(dateOfBirth)) {
                if (dateException.checkAgeGreater18(dateOfBirth)) {
                    break;
                }
            }
            System.out.print("The input date is invalid, please try again: ");
        } while (true);
        System.out.println("---oOo---");
        System.out.println("1. Male / 2. Female");
        System.out.print("Enter your new gender: ");
        do {
            choiceGender = Integer.parseInt(scanner.nextLine());
            if (choiceGender == 1) {
                gender = "Male";
                break;
            }
            if (choiceGender == 2) {
                gender = "female";
                break;
            }
            System.out.print("The input gender is not correct, please input 1 or 2:");
        } while (true);
        System.out.print("Enter your new identification card:");
        do {
            identificationCard = scanner.nextLine();
            if (employeeRegex.checkIdCardEmployeeRegex(identificationCard)) {
                break;
            }
            System.out.print("Id card must have 9 or 12 numbers, please try again: ");
        } while (true);
        System.out.print("Enter your new phone number: ");
        do {
            phoneNumber = scanner.nextLine();
            if (employeeRegex.checkPhoneNumberEmployeeRegex(phoneNumber)) {
                break;
            }
            System.out.print("Phone number must have 10 numbers and start with 0, please try again: ");
        } while (true);
        System.out.print("Enter your new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your new employee code: ");
        do {
            employeeCode = scanner.nextLine();
            if (employeeRegex.checkCodeEmployeeRegex(employeeCode)) {
                break;
            }
            System.out.print("invalid code, please try again: ");
        } while (true);
        System.out.print("Enter your new education: ");
        String education = scanner.nextLine();
        System.out.print("Enter your new position: ");
        String position = scanner.nextLine();
        System.out.print("Enter your new salary: ");
        do {
            stringSalary = scanner.nextLine();
            if (employeeRegex.checkSalaryEmployeeRegex(stringSalary)) {
                salary = Long.valueOf(stringSalary);
                break;
            }
            System.out.print("The input salary is invalid, please try again: ");
        } while (true);

        Employee newEmployee = new Employee(name, dateOfBirth, gender, identificationCard, phoneNumber, email, employeeCode, education, position, salary);
        return newEmployee;
    }

    public String checkInputEditProperty(int choice) {
        String newValue = null;
        boolean check = false;
        int choiceGender;
        do {
            if (choice != 3) {
                newValue = scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    check = employeeRegex.checkNameEmployeeRegex(newValue);
                    if (!check) {
                        System.out.println("invalid name, try again");
                    }
                    break;
                case 2:
                    if (employeeRegex.checkAgeEmployeeRegex(newValue)) {
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
                    check = employeeRegex.checkIdCardEmployeeRegex(newValue);
                    if (!check) {
                        System.out.println("invalid id card, try again");
                    }
                    break;
                case 5:
                    check = employeeRegex.checkPhoneNumberEmployeeRegex(newValue);
                    if (!check) {
                        System.out.println("invalid phone number, try again");
                    }
                    break;
                case 9:
                    check = employeeRegex.checkSalaryEmployeeRegex(newValue);
                    if (!check) {
                        System.out.println("invalid salary, try again");
                    }
                    break;
                case 6:
                    break;
                case 7:
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
