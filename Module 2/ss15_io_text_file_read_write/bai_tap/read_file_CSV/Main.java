package ss15_io_text_file_read_write.bai_tap.read_file_CSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PATH_OF_COUNTRY_FILE = "D:\\4K\\codeG du an ngoai\\module_2_java\\untitled\\src\\ss15_io_text_file_read_write\\bai_tap\\read_file_CSV\\countries.csv";

    public static List<Country> readCSV(String pathFile) {
        BufferedReader bufferedReader = null;
        List<Country> countryList = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            bufferedReader = new BufferedReader(fileReader);
            countryList = new ArrayList<>();
            String line = null;
            String[] temp;
            int id;
            String code;
            String name;
            Country country;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                id = Integer.parseInt(temp[0]);
                code = temp[1];
                name = temp[2];
                country = new Country(id, code, name);
                countryList.add(country);
            }
        } catch (IOException e) {
            System.out.println("Path of file is not found");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Error closing BufferedReader");
                }
            }
        }
        return countryList;
    }

    public static void main(String[] args) {
        List<Country> countryList = readCSV(PATH_OF_COUNTRY_FILE);
        for (Country country : countryList) {
            System.out.println(country);
        }
    }
}
