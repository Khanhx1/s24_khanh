package furama_resort.views;

import furama_resort.controllers.FacilityController;
import furama_resort.models.facility.Facility;
import furama_resort.models.facility.House;
import furama_resort.models.facility.Room;
import furama_resort.models.facility.Villa;
import furama_resort.utils.exception.FacilityCondition;
import furama_resort.utils.exception.NumberException;
import furama_resort.utils.regex.facility.FacilityRegex;

import java.math.RoundingMode;
import java.util.Map;
import java.util.Scanner;

public class FacilityManagement {
    private int choice;
    private NumberException numberException = new NumberException();
    private Scanner scanner = new Scanner(System.in);
    private FacilityRegex facilityRegex = new FacilityRegex();
    private FacilityCondition facilityCondition = new FacilityCondition();
    private FacilityController facilityController = new FacilityController();

    public void manageFacility() {
        String codeFacility;
        do {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Delete facility");
            System.out.println("5. Return main menu");
            choice = numberException.inputIntegerNumberException();
            switch (choice) {
                case 2:
                    addFacility();
                    break;
                case 1:
                    Map<Facility,Integer> facilityIntegerMap = facilityController.findAllMap();
                    for (Facility key: facilityIntegerMap.keySet()) {
                        System.out.println(key + "- value: " + facilityIntegerMap.get(key));
                    }
                    break;
                case 4:
                    System.out.println("enter your code facility you want to remove: ");
                    codeFacility = scanner.nextLine();
                    Facility facility = facilityController.findByCodeMap(codeFacility);
                    if(facility != null) {
                        facilityController.removeMap(codeFacility);
                        System.out.println("successfully");
                    } else {
                        System.out.println("input code is not found");
                    }
                    break;
                case 3:
                    Map<Facility, Integer> mapMaintenance = facilityController.showMaintenance();
                    for (Facility key : mapMaintenance.keySet()) {
                        System.out.println(key + " - value: " + mapMaintenance.get(key));
                    }
                    break;
                default:
                    System.out.println("invalid input, try again: ");
            }
        } while (choice != 5);
    }

    public void addFacility() {
        boolean check;
        do {
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.print("---Enter your choice---");
            do {
                check = false;
                choice = numberException.inputIntegerNumberException();
                switch (choice) {
                    case 1:
                        Villa villa = inputVilla();
                        facilityController.addVilla(villa);
                        System.out.println("successfully");
                        break;
                    case 2:
                        House house = inputHouse();
                        facilityController.addHouse(house);
                        System.out.println("successfully");
                        break;
                    case 3:
                        Room room = inputRoom();
                        facilityController.addRoom(room);
                        System.out.println("successfully");
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("invalid choice, try again: ");
                        check = true;
                }
            } while (check);
        } while (choice != 4);
    }

    public Villa inputVilla() {
        String codeService;
        String nameService;
        Double usageArea;
        Long rentalCost;
        Integer maximumPeople;
        int choiceRental;
        String typeOfRental;
        Double poolArea;
        Integer numberOfFloors;
        System.out.print("Enter code Villa: ");
        do {
            codeService = scanner.nextLine();
            if (facilityRegex.checkCodeVillaRegex(codeService)) {
                break;
            }
            System.out.print("invalid code, try again:");
        } while (true);
        System.out.print("Enter name service: ");
        do {
            nameService = scanner.nextLine();
            if (facilityRegex.checknameRegex(nameService)) {
                break;
            }
            System.out.println("invalid name, try again: ");
        } while (true);
        System.out.print("Enter area: ");
        do {
            usageArea = numberException.inputDoubleNumberException();
            if (facilityCondition.checkAreaGreaterThan30(usageArea)) {
                break;
            }
            System.out.print("invalid area, try again: ");
        } while (true);
        System.out.print("Enter rental cost: ");
        do {
            rentalCost = numberException.inputLongNumberException();
            if (facilityCondition.checkRentalCost(rentalCost)) {
                break;
            }
            System.out.print("invalid input, try again: ");
        } while (true);
        System.out.print("Enter maximum people: ");
        do {
            maximumPeople = numberException.inputIntegerNumberException();
            if (facilityCondition.checkMaximumPeople(maximumPeople)) {
                break;
            }
            System.out.print("invalid input, try again: ");
        } while (true);
        System.out.println("---(type of rental)---");
        System.out.print("1. day" + "\n" + "2. month" + "\n" + "3. year" + "\n");
        System.out.print("Enter your choice: ");
        do {
            choiceRental = numberException.inputIntegerNumberException();
            if (choiceRental == 1) {
                typeOfRental = "day";
                break;
            } else if (choiceRental == 2) {
                typeOfRental = "month";
                break;
            } else if (choiceRental == 3) {
                typeOfRental = "year";
                break;
            } else {
                System.out.print("invalid choice, try again: ");
            }
        } while (true);
        System.out.print("Enter standard: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Enter area pool: ");
        do {
            poolArea = numberException.inputDoubleNumberException();
            if (facilityCondition.checkAreaGreaterThan30(poolArea)) {
                break;
            }
            System.out.print("invalid input, try again: ");
        } while (true);
        System.out.println("Enter floor: ");
        do {
            numberOfFloors = numberException.inputIntegerNumberException();
            if (facilityCondition.checkFloors(numberOfFloors)) {
                break;
            }
            System.out.print("invalid input, try again: ");
        } while (true);
        Villa villa = new Villa(codeService, nameService, usageArea, rentalCost, maximumPeople, typeOfRental, roomStandard, poolArea, numberOfFloors);
        return villa;
    }

    public House inputHouse() {
        String codeService;
        String nameService;
        Double usageArea;
        Long rentalCost;
        Integer maximumPeople;
        int choiceRental;
        String typeOfRental;
        Integer numberOfFloors;
        System.out.print("Enter code house: ");
        do {
            codeService = scanner.nextLine();
            if (facilityRegex.checkCodeHouseRegex(codeService)) {
                break;
            }
            System.out.print("invalid code, try again:");
        } while (true);
        System.out.print("Enter name service: ");
        do {
            nameService = scanner.nextLine();
            if (facilityRegex.checknameRegex(nameService)) {
                break;
            }
            System.out.println("invalid name, try again: ");
        } while (true);
        System.out.print("Enter area: ");
        do {
            usageArea = numberException.inputDoubleNumberException();
            if (facilityCondition.checkAreaGreaterThan30(usageArea)) {
                break;
            }
            System.out.print("invalid area, try again: ");
        } while (true);
        System.out.print("Enter rental cost: ");
        do {
            rentalCost = numberException.inputLongNumberException();
            if (facilityCondition.checkRentalCost(rentalCost)) {
                break;
            }
            System.out.print("invalid input, try again: ");
        } while (true);
        System.out.print("Enter maximum people: ");
        do {
            maximumPeople = numberException.inputIntegerNumberException();
            if (facilityCondition.checkMaximumPeople(maximumPeople)) {
                break;
            }
            System.out.print("invalid input, try again: ");
        } while (true);
        System.out.println("---(type of rental)---");
        System.out.print("1. day" + "\n" + "2. month" + "\n" + "3. year" + "\n");
        System.out.print("Enter your choice: ");
        do {
            choiceRental = numberException.inputIntegerNumberException();
            if (choiceRental == 1) {
                typeOfRental = "day";
                break;
            } else if (choiceRental == 2) {
                typeOfRental = "month";
                break;
            } else if (choiceRental == 3) {
                typeOfRental = "year";
                break;
            } else {
                System.out.print("invalid choice, try again: ");
            }
        } while (true);
        System.out.print("Enter standard: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Enter floor: ");
        do {
            numberOfFloors = numberException.inputIntegerNumberException();
            if (facilityCondition.checkFloors(numberOfFloors)) {
                break;
            }
            System.out.print("invalid input, try again: ");
        } while (true);
        House house = new House(codeService, nameService, usageArea, rentalCost, maximumPeople, typeOfRental, roomStandard, numberOfFloors);
        return house;
    }

    public Room inputRoom() {
        String codeService;
        String nameService;
        Double usageArea;
        Long rentalCost;
        Integer maximumPeople;
        int choiceRental;
        String typeOfRental;
        Integer numberOfFloors;
        System.out.print("Enter code room: ");
        do {
            codeService = scanner.nextLine();
            if (facilityRegex.checkCodeRoomRegex(codeService)) {
                break;
            }
            System.out.print("invalid code, try again:");
        } while (true);
        System.out.print("Enter name service: ");
        do {
            nameService = scanner.nextLine();
            if (facilityRegex.checknameRegex(nameService)) {
                break;
            }
            System.out.println("invalid name, try again: ");
        } while (true);
        System.out.print("Enter area: ");
        do {
            usageArea = numberException.inputDoubleNumberException();
            if (facilityCondition.checkAreaGreaterThan30(usageArea)) {
                break;
            }
            System.out.print("invalid area, try again: ");
        } while (true);
        System.out.print("Enter rental cost: ");
        do {
            rentalCost = numberException.inputLongNumberException();
            if (facilityCondition.checkRentalCost(rentalCost)) {
                break;
            }
            System.out.print("invalid input, try again: ");
        } while (true);
        System.out.print("Enter maximum people: ");
        do {
            maximumPeople = numberException.inputIntegerNumberException();
            if (facilityCondition.checkMaximumPeople(maximumPeople)) {
                break;
            }
            System.out.print("invalid input, try again: ");
        } while (true);
        System.out.println("---(type of rental)---");
        System.out.print("1. day" + "\n" + "2. month" + "\n" + "3. year" + "\n");
        System.out.print("Enter your choice: ");
        do {
            choiceRental = numberException.inputIntegerNumberException();
            if (choiceRental == 1) {
                typeOfRental = "day";
                break;
            } else if (choiceRental == 2) {
                typeOfRental = "month";
                break;
            } else if (choiceRental == 3) {
                typeOfRental = "year";
                break;
            } else {
                System.out.print("invalid choice, try again: ");
            }
        } while (true);
        System.out.print("Enter complimentary service: ");
        String complimentaryService = scanner.nextLine();
        Room room = new Room(codeService, nameService, usageArea, rentalCost, maximumPeople, typeOfRental, complimentaryService);
        return room;
    }
}
