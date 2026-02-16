package linearbinarysearch;
/*
 * This class demonstrates converting a byte stream into a character stream
 * using InputStreamReader with a specified charset (UTF-8).
 * It reads binary data from a file and prints it as readable characters.
 * BufferedReader is used to improve reading efficiency.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderCharsetPrinter {

    // Reads a binary file and prints it as characters using UTF-8 encoding
    public static void readFile(String filePath) {

        // Ensures all streams are closed automatically
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) { // Stops when end of file is reached
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        String filePath = "sample_utf8.txt"; // Update path if file is located elsewhere
        readFile(filePath);
    }
}
