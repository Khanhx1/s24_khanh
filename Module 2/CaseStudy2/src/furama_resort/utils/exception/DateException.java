package furama_resort.utils.exception;

import java.time.LocalDate;
import java.time.Period;

public class DateException {
    public boolean checkAgeGreater18(String date) {
        String[] dateOfBirthArray = date.split("/");
        int day = Integer.parseInt(dateOfBirthArray[0]);
        int month = Integer.parseInt(dateOfBirthArray[1]);
        int year = Integer.parseInt(dateOfBirthArray[2]);
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateOfBirth, now);
        int minusYear = period.getYears();
        if (minusYear >= 18) {
            return true;
        }
        return false;
    }
}
