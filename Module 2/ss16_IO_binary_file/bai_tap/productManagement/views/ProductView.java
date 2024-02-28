package ss16_IO_binary_file.bai_tap.productManagement.views;


import ss16_IO_binary_file.bai_tap.productManagement.controllers.ProductController;
import ss16_IO_binary_file.bai_tap.productManagement.models.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private ProductController productController = new ProductController();
    private Scanner scanner = new Scanner(System.in);

    public void ProductMenu() {
        int choice;
        String code;
        Product newProduct;
        List<Product> productList;
        Product product;
        do {
            System.out.println("1. Add product");
            System.out.println("2. Display product");
            System.out.println("3. search product");
            System.out.println("4. Exit");
            System.out.println("------Enter your choice------");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    newProduct = inputProduct();
                    productController.addProduct(newProduct);
                    break;
                case 2:
                    productList = productController.findAllList();
                    for (Product product1 : productList) {
                        System.out.println(product1);
                    }
                    break;
                case 3:
                    System.out.println("Enter code product you want to find");
                    code = scanner.nextLine();
                    product = productController.findByCode(code);
                    if (product != null) {
                        System.out.println("Your product you find: " + product);
                    } else {
                        System.out.println("The code that you type is not found");
                    }
                    break;
            }
        } while (choice != 4);
    }

    public Product inputProduct() {
        String newCode = null;
        String newName = null;
        Long newPrice = null;
        String newType = null;
        String newDescription = null;
        try {
            System.out.println("Enter new code product");
            newCode = scanner.nextLine();
            System.out.println("Enter new name product");
            newName = scanner.nextLine();
            System.out.println("Enter new price product");
            newPrice = Long.valueOf(scanner.nextLine());
            System.out.println("Enter new type of goods");
            newType = scanner.nextLine();
            System.out.println("Enter new description product");
            newDescription = scanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Invalid inputted price");
        }
        return new Product(newCode, newName, newPrice, newType, newDescription);
    }
}
