package ss15_io_text_file_read_write.bai_tap.copy_file_text;

import java.io.*;

public class CopyOperation {
    private static final String PATH_SOURCE_FILE = "D:\\4K\\codeG du an ngoai\\module_2_java\\untitled\\src\\ss15_io_text_file_read_write\\bai_tap\\copy_file_text\\source_file.csv";
    private static final String PATH_TARGET_FILE = "D:\\4K\\codeG du an ngoai\\module_2_java\\untitled\\src\\ss15_io_text_file_read_write\\bai_tap\\copy_file_text\\target_file.csv";

    public static String getValueByReadCSV(String pathFile) {
        String readResult = null;
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            readResult = "";
            while ((line = bufferedReader.readLine()) != null) {
                readResult += line + "\n";
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
        return readResult;
    }

    public static void writeCSV(String inputValue, String pathFile) {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(inputValue);
        } catch (IOException e) {
            System.out.println("Path of file is not found");
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Error closing BufferedReader");
                }
            }
        }
    }

    public static int countCharacterInCSVFile(String pathFile) {
        BufferedReader bufferedReader = null;
        int count = 0;
        try {
            FileReader fileReader = new FileReader(pathFile);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                count += line.length();
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
        return count;
    }

    public static void main(String[] args) {
        writeCSV(getValueByReadCSV(PATH_SOURCE_FILE), PATH_TARGET_FILE);
        System.out.println("Copied file has " + countCharacterInCSVFile(PATH_TARGET_FILE) + " characters");
    }
}
