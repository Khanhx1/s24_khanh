package furama_resort.utils.exception;

import java.util.Scanner;

public class NumberException {
    private Scanner scanner = new Scanner(System.in);

    public int inputIntegerNumberException() {
        int count = 0;
        int number = 0;
        do {
            count = 0;
            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                count++;
                System.out.println("The input number is invalid");
            }
        } while (count != 0);
        return number;
    }
    public Long inputLongNumberException() {
        int count = 0;
        Long number = null;
        do {
            count = 0;
            try {
                number = Long.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                count++;
                System.out.println("The input number is invalid");
            }
        } while (count != 0);
        return number;
    }
    public Double inputDoubleNumberException() {
        int count = 0;
        Double number = null;
        do {
            count = 0;
            try {
                number = Double.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                count++;
                System.out.println("The input number is invalid");
            }
        } while (count != 0);
        return number;
    }
}
