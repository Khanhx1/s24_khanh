package ss14_bug_exception.bai_tap;

import java.util.Scanner;

public class CheckTriangleException {
    private static double edge1;
    private static double edge2;
    private static double edge3;
    private static Scanner scanner = new Scanner(System.in);

    public static void checkConditionTriangleException(double edge1, double edge2, double edge3) {
        if (edge1 <= 0 || edge2 <= 0 || edge3 <= 0) {
            throw new IllegalTriangleException("Edge of triangle must be a positive number.");
        }
        if (edge1 + edge2 <= edge3 || edge1 + edge3 <= edge2 || edge2 + edge3 <= edge1) {
            throw new IllegalTriangleException("The input edge does not meet the triangle's conditions.");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Enter first edge:");
            edge1 = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter second edge:");
            edge2 = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter third edge:");
            edge3 = Double.parseDouble(scanner.nextLine());
            checkConditionTriangleException(edge1, edge2, edge3);
            System.out.println("The edge that you type is triangle's edge");
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("The input is non-numeric and is not accepted here.");
        }
    }
}

