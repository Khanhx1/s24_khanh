package ss18_regex.thuc_hanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    private static final String REGEX = "";


    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher("C0987K");
        System.out.println(matcher.matches());
    }
}
