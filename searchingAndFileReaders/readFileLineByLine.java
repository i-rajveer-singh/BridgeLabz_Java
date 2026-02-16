package linearbinarysearch;
/*
 * This class reads a text file line by line using FileReader wrapped inside BufferedReader.
 * BufferedReader improves efficiency by reducing direct disk access.
 * Demonstrates proper resource management with try-with-resources.
 * Prints each line of the file to the console.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderLineByLineUnique {

    // Reads and prints the file content line by line
    public static void readFile(String filePath) {

        // try-with-resources ensures the reader is automatically closed
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) { // readLine() returns null at end of file
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage()); // Handles both FileNotFound & read errors
        }
    }

    public static void main(String[] args) {

        String filePath = "sample.txt"; // Change path if the file is located elsewhere
        readFile(filePath);
    }
}
