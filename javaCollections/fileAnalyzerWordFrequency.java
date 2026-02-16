package collections;
/*
 * WordFrequencyFileAnalyzer reads text from a file, normalizes case,
 * removes punctuation, and counts occurrences of each word using HashMap.
 */

import java.util.*;
import java.io.*;

public class WordFrequencyFileAnalyzer {

    // Counts word frequency from a file
    public static Map<String, Integer> countWords(String filePath) throws IOException {

        Map<String, Integer> freq = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;

        while ((line = reader.readLine()) != null) {
            line = line.toLowerCase().replaceAll("[^a-z0-9 ]", ""); // Remove punctuation

            for (String word : line.split("\\s+")) {
                if (!word.isEmpty())
                    freq.put(word, freq.getOrDefault(word, 0) + 1); // Increment safely
            }
        }

        reader.close();
        return freq;
    }

    // Entry point
    public static void main(String[] args) throws Exception {

        String path = "sample.txt"; // Ensure file exists

        System.out.println(countWords(path));
    }
}
