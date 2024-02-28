package ss18_regex.thuc_hanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1a {
    private static final  String REGEX_ID = "^[0-9]{4}$";
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(REGEX_ID);
        Matcher matcher = pattern.matcher("1234");
        System.out.println(matcher.matches());

//        System.out.println("1234".matches(REGEX_ID));
    }
}
