package linearbinarysearch;
/*
 * This class compares the performance of StringBuffer and StringBuilder
 * when concatenating a large number of strings.
 * It measures execution time using System.nanoTime() to provide precise timing.
 * Helps understand the overhead of synchronization in StringBuffer vs StringBuilder.
 */

public class BufferVsBuilderPerformanceCheck {

    private static final int ITERATIONS = 1_000_000; // Large dataset for noticeable timing difference

    // Measures time taken by StringBuffer for concatenation
    public static long testStringBuffer() {
        StringBuffer buffer = new StringBuffer();
        long start = System.nanoTime();

        for (int i = 0; i < ITERATIONS; i++) {
            buffer.append("hello");
        }

        return System.nanoTime() - start; // Returning elapsed time in nanoseconds
    }

    // Measures time taken by StringBuilder for concatenation
    public static long testStringBuilder() {
        StringBuilder builder = new StringBuilder();
        long start = System.nanoTime();

        for (int i = 0; i < ITERATIONS; i++) {
            builder.append("hello");
        }

        return System.nanoTime() - start;
    }

    public static void main(String[] args) {

        long bufferTime = testStringBuffer();
        long builderTime = testStringBuilder();

        System.out.println("StringBuffer Time (ns): " + bufferTime);
        System.out.println("StringBuilder Time (ns): " + builderTime);

        // Converting to milliseconds for easier human reading
        System.out.println("StringBuffer Time (ms): " + bufferTime / 1_000_000);
        System.out.println("StringBuilder Time (ms): " + builderTime / 1_000_000);
    }
}
