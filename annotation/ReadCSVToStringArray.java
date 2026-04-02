package annotation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCSVToStringArray {

    public static void main(String[] args) {

        String filePath = "C:\\BridgeLabz_Practisedata.csv";

        ArrayList<String[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");  // Split by comma
                dataList.add(values);
            }

            // Convert ArrayList to String[][]
            String[][] dataArray = dataList.toArray(new String[0][]);

            // Print Data
            System.out.println("CSV Data:\n");

            for (String[] row : dataArray) {
                for (String value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}