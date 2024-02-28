package ss16_IO_binary_file.bai_tap.productManagement.util;


import ss16_IO_binary_file.bai_tap.productManagement.models.Product;

import java.io.*;
import java.util.List;

public class WriteObject {
    private final String PATH_OF_STORAGE_FILE = "D:\\4K\\codeG du an ngoai\\luyen tap MVC\\src\\ss16_IO_binary_file\\bai_tap\\productManagement\\common\\storage.dat";

    public void writeObjectListIntoFile(List<Product> productList) {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH_OF_STORAGE_FILE);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
        } catch (IOException e) {
            System.out.println("Path of file is not found");
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    System.out.println("Error closing object output stream");
                }
            }
        }

    }
}
