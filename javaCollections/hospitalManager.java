package collections;
/*
 * HospitalTriageManager simulates patient treatment priority
 * using a PriorityQueue so higher severity cases are handled first.
 */

import java.util.*;

// Represents a patient with severity
class Patient implements Comparable<Patient> {

    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Ensures higher severity gets priority
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    // Returns patient name
    public String getName() {
        return name;
    }
}

public class HospitalTriageManager {

    // Entry point
    public static void main(String[] args) {

        PriorityQueue<Patient> pq = new PriorityQueue<>();

        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        while (!pq.isEmpty()) {
            System.out.println(pq.remove().getName());
        }
    }
}
