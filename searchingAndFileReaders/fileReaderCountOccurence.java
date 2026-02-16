package linearbinarysearch;

/*
 * This class counts how many times a specific word appears in a text file.
 * It uses FileReader with BufferedReader for efficient reading.
 * Each line is processed and split into words for comparison.
 * Demonstrates basic file handling and text processing in Java.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWordOccurrenceTracker {

    // Counts occurrences of the target word in the file
    public static int countWord(String filePath, String targetWord) {

        int count = 0;
        String normalizedTarget = targetWord.toLowerCase(); // Normalize for case-insensitive matching

        // Automatically closes resources after use
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {

                // Removing punctuation avoids mismatches like "word," vs "word"
                String[] words = line.toLowerCase().replaceAll("[^a-z0-9 ]", "").split("\\s+");

                for (String word : words) {
                    if (word.equals(normalizedTarget)) {
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {

        String filePath = "sample.txt"; // Update path if needed
        String targetWord = "java";

        int occurrences = countWord(filePath, targetWord);
        System.out.println("The word \"" + targetWord + "\" appears " + occurrences + " times.");
    }
}

