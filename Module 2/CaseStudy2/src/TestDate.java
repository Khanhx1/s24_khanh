import java.time.LocalDate;
import java.time.Period;

public class TestDate {
    public static void main(String[] args) {
        int day = 2;
        int month = 12;
        int year = 2022;
        LocalDate d1 = LocalDate.of(year,month,day);
        LocalDate now1 = LocalDate.now();    //2023-12-3
        Period period = Period.between(d1, now1);

        System.out.println("years: " + period.getYears());
        System.out.println("months: " + period.getMonths());
        System.out.println("days: " + period.getDays());
    }
}
