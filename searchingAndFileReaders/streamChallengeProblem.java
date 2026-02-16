package linearbinarysearch;

/*
 * This class compares StringBuilder vs StringBuffer for large-scale concatenation
 * and FileReader vs InputStreamReader for reading a large file.
 * It measures execution time using System.nanoTime() and counts total words.
 * Helps understand performance differences and proper stream usage in Java.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class IOAndStringPerformanceComparator {

    private static final int ITERATIONS = 1_000_000; // Large loop for performance testing

    // Tests concatenation speed using StringBuilder
    public static long testStringBuilder(List<String> data) {

        StringBuilder builder = new StringBuilder();
        long start = System.nanoTime();

        for (int i = 0; i < ITERATIONS; i++) {
            for (String str : data) {
                builder.append(str);
            }
        }

        return System.nanoTime() - start;
    }

    // Tests concatenation speed using StringBuffer
    public static long testStringBuffer(List<String> data) {

        StringBuffer buffer = new StringBuffer(); // Thread-safe but slower due to synchronization
        long start = System.nanoTime();

        for (int i = 0; i < ITERATIONS; i++) {
            for (String str : data) {
                buffer.append(str);
            }
        }

        return System.nanoTime() - start;
    }

    // Counts words using FileReader
    public static long countWordsWithFileReader(String filePath) {

        long wordCount = 0;
        long start = System.nanoTime();

        // try-with-resources automatically closes streams
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Splitting on whitespace counts words
            }

        } catch (IOException e) {
            System.out.println("FileReader error: " + e.getMessage());
        }

        long elapsed = System.nanoTime() - start;
        System.out.println("FileReader Word Count: " + wordCount);
        return elapsed;
    }

    // Counts words using InputStreamReader with explicit UTF-8 encoding
    public static long countWordsWithInputStreamReader(String filePath) {

        long wordCount = 0;
        long start = System.nanoTime();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }

        } catch (IOException e) {
            System.out.println("InputStreamReader error: " + e.getMessage());
        }

        long elapsed = System.nanoTime() - start;
        System.out.println("InputStreamReader Word Count: " + wordCount);
        return elapsed;
    }

    public static void main(String[] args) {

        List<String> sampleData = Arrays.asList("hello", "world", "java", "performance");
        String filePath = "largefile.txt"; // Replace with the path to your ~100MB file

        long builderTime = testStringBuilder(sampleData);
        long bufferTime = testStringBuffer(sampleData);

        System.out.println("StringBuilder Time (ms): " + builderTime / 1_000_000);
        System.out.println("StringBuffer Time (ms): " + bufferTime / 1_000_000);

        long fileReaderTime = countWordsWithFileReader(filePath);
        long inputStreamReaderTime = countWordsWithInputStreamReader(filePath);

        System.out.println("FileReader Time (ms): " + fileReaderTime / 1_000_000);
        System.out.println("InputStreamReader Time (ms): " + inputStreamReaderTime / 1_000_000);
    }
}

