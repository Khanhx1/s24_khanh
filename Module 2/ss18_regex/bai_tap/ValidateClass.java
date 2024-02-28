package ss18_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static final String REGEX = "^[CAP]\\d{4}[GHIK]$";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Class's name:");
        String className = scanner.nextLine();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(className);
        if (matcher.matches()) {
            System.out.println("Class's name is valid");
        } else {
            System.out.println("Class's name is invalid");
        }
    }
}
