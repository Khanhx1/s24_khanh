public class TestRegex {
    public static void main(String[] args) {
        String xx ="can cuoc co 9 hoac 12 so";
        String REGEX = "^(\\d{9}|\\d{12})$";
        String REGEX2 = "^\\d{9}\\d{3}?$";
    }
}
