package ss16_IO_binary_file.bai_tap.productManagement.util;


import ss16_IO_binary_file.bai_tap.productManagement.models.Product;

import java.io.*;
import java.util.List;

public class ReadObject {
    private final String PATH_OF_STORAGE_FILE = "D:\\4K\\codeG du an ngoai\\luyen tap MVC\\src\\ss16_IO_binary_file\\bai_tap\\productManagement\\common\\storage.dat";

    public List<Product> readObjectList() {
        ObjectInputStream objectInputStream = null;
        List<Product> productList = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH_OF_STORAGE_FILE);
            objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Path of file is not found");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    System.out.println("Error closing object input stream");
                }
            }
        }
        return productList;
    }
}
