package ss18_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static final String REGEX = "\\(\\d{2}\\)-\\(0\\d{9}\\)";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()){
            System.out.println("valid phone number");
        } else {
            System.out.println("invalid phone number");
        }
    }
}
