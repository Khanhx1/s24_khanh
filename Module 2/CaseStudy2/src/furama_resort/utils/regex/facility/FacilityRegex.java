package furama_resort.utils.regex.facility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacilityRegex {
    public boolean checkCodeVillaRegex(String code) {
        String REGEX = "^SVVL-\\d{4}$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(code);
        return (matcher.matches());
    }
    public boolean checkCodeHouseRegex(String code) {
        String REGEX = "^SVHO-\\d{4}$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(code);
        return (matcher.matches());
    }
    public boolean checkCodeRoomRegex(String code) {
        String REGEX = "^SVRO-\\d{4}$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(code);
        return (matcher.matches());
    }
    public boolean checknameRegex(String code) {
        String REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(code);
        return (matcher.matches());
    }
}
