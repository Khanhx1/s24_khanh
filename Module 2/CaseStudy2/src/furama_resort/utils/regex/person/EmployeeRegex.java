package furama_resort.utils.regex.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeRegex {
    private String REGEX = null;

    public boolean checkCodeEmployeeRegex(String code) {
        String REGEX = "^NV-\\d{4}$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(code);
        return (matcher.matches());
    }
    public boolean checkNameEmployeeRegex(String name) {
        String REGEX = "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)*$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(name);
        return (matcher.matches());
    }
    public boolean checkAgeEmployeeRegex(String date) {
        String REGEX = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(date);
        return (matcher.matches());
    }
    public boolean checkIdCardEmployeeRegex(String id) {
        String REGEX = "^(\\d{9}|\\d{12})$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(id);
        return (matcher.matches());
    }
    public boolean checkPhoneNumberEmployeeRegex(String phoneNumber) {
        String REGEX = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return (matcher.matches());
    }
    public boolean checkSalaryEmployeeRegex(String salary) {
        String REGEX = "^[1-9]\\d*$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(salary);
        return (matcher.matches());
    }

}
