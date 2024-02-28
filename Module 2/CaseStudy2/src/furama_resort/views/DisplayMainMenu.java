package furama_resort.views;

import furama_resort.utils.exception.NumberException;

import java.util.Scanner;

public class DisplayMainMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static ManagementFunction managementFunction = new ManagementFunction();
    private static NumberException numberException = new NumberException();
    private static CustomerManagement customerManagement = new CustomerManagement();
    private static FacilityManagement facilityManagement = new FacilityManagement();
    private static int choice;
    public static void main(String[] args) {
        do {
            System.out.println("****** MAIN MENU ******");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("--------Enter your option-------");
           choice =  numberException.inputIntegerNumberException();
            switch (choice) {
                case 1:
                    managementFunction.manageEmployee();
                    break;
                case 2:
                    customerManagement.manageCustomer();
                    break;
                case 3:
                    facilityManagement.manageFacility();
                    break;
                case 4:
                    managementFunction.manageBooking();
                    break;
                case 5:
                    managementFunction.managePromotion();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("try again");
            }
        } while (true);
    }
}
