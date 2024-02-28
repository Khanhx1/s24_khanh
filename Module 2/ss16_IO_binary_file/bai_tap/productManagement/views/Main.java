package ss16_IO_binary_file.bai_tap.productManagement.views;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductView productView = new ProductView();
        int choice;
        do {
            System.out.println("Option:");
            System.out.println("1. Manager product");
            System.out.println("2. Exit");
            System.out.println("-------Enter your option-------");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productView.ProductMenu();
                    break;
                case 2:
                    System.exit(0);
            }
        } while (true);
    }
}
