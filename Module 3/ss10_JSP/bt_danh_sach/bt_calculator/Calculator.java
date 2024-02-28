package org.example.demo_jstl;

public class Calculator {
public Float calculate(Float first, Float second, String operator) throws Exception {
    Float result = 0.0f;
        switch (operator) {
            case "add":
                result = first + second;
                break;
            case "minus":
                result = first - second;
                break;
            case "multiplication":
                result = first * second;
                break;
            case "division":
                if (second == 0) {
                    throw new Exception("invalid number");
                } else {
                    result = first / second;
                }
                break;
            default:
                throw new Exception("invalid operator");
        }

    return result;
}
}
