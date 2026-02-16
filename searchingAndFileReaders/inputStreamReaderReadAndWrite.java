package linearbinarysearch;
/*
 * This class reads user input from the console using InputStreamReader
 * and writes each line to a file.
 * The program continues until the user types "exit".
 * Demonstrates console input handling and file writing in Java.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputStreamReaderToFileWriterUnique {

    // Reads console input and writes it to a file line by line
    public static void writeUserInputToFile(String filePath) {

        // try-with-resources ensures all streams are closed automatically
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(filePath, true)) { // true enables append mode

            String input;
            System.out.println("Enter text (type 'exit' to stop):");

            while ((input = br.readLine()) != null) {

                if (input.equalsIgnoreCase("exit")) { // Stops the loop when user types exit
                    break;
                }

                writer.write(input + System.lineSeparator()); // Ensures each entry is on a new line
            }

            System.out.println("Input successfully written to file.");

        } catch (IOException e) {
            System.out.println("Error handling input/output: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        String filePath = "user_input.txt"; // Change path if needed
        writeUserInputToFile(filePath);
    }
}
