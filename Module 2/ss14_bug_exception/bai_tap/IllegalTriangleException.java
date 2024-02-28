package ss14_bug_exception.bai_tap;

public class IllegalTriangleException extends NumberFormatException {
    public IllegalTriangleException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
