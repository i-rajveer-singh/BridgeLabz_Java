package collections;
/*
 * PolicyVaultSystem manages insurance policies using HashSet, LinkedHashSet,
 * and TreeSet to demonstrate uniqueness, insertion order, and sorted storage.
 * It supports advanced retrieval like expiring policies, coverage filtering,
 * duplicate detection, and compares performance across different Set types.
 */

import java.util.*;
import java.time.*;

// Represents an insurance policy
class InsurancePolicy implements Comparable<InsurancePolicy> {

    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName,
                           LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Returns policy number
    public String getPolicyNumber() { return policyNumber; }

    // Returns expiry date
    public LocalDate getExpiryDate() { return expiryDate; }

    // Returns coverage type
    public String getCoverageType() { return coverageType; }

    // Ensures uniqueness based on policy number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy other = (InsurancePolicy) obj;
        return policyNumber.equals(other.policyNumber);
    }

    // Generates hash using policy number
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Sorts policies by expiry date
    @Override
    public int compareTo(InsurancePolicy other) {
        int dateCompare = this.expiryDate.compareTo(other.expiryDate);
        if (dateCompare == 0)
            return this.policyNumber.compareTo(other.policyNumber); // Prevent duplicate clash in TreeSet
        return dateCompare;
    }

    // Formats policy details
    @Override
    public String toString() {
        return policyNumber + " | " + policyholderName + " | " +
                expiryDate + " | " + coverageType + " | $" + premiumAmount;
    }
}

public class PolicyVaultSystem {

    private Set<InsurancePolicy> hashPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treePolicies = new TreeSet<>();

    private Set<String> duplicateTracker = new HashSet<>();

    // Adds policy into all sets and tracks duplicates
    public void addPolicy(InsurancePolicy policy) {
        if (!duplicateTracker.add(policy.getPolicyNumber())) {
            System.out.println("Duplicate Policy Detected: " + policy.getPolicyNumber());
        }
        hashPolicies.add(policy);
        linkedPolicies.add(policy);
        treePolicies.add(policy);
    }

    // Displays all unique policies
    public void displayAllPolicies() {
        hashPolicies.forEach(System.out::println);
    }

    // Retrieves policies expiring within given days
    public void policiesExpiringSoon(int days) {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(days);

        treePolicies.stream()
                .filter(p -> !p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(limit))
                .forEach(System.out::println);
    }

    // Filters policies by coverage type
    public void policiesByCoverage(String coverage) {
        hashPolicies.stream()
                .filter(p -> p.getCoverageType().equalsIgnoreCase(coverage))
                .forEach(System.out::println);
    }

    // Compares performance of different sets
    public void comparePerformance(List<InsurancePolicy> policies) {

        compareSet(new HashSet<>(), policies, "HashSet");
        compareSet(new LinkedHashSet<>(), policies, "LinkedHashSet");
        compareSet(new TreeSet<>(), policies, "TreeSet");
    }

    // Measures add, search, remove time for a set
    private void compareSet(Set<InsurancePolicy> set, List<InsurancePolicy> policies, String name) {

        long start = System.nanoTime();
        set.addAll(policies);
        long addTime = System.nanoTime() - start;

        InsurancePolicy sample = policies.get(policies.size() / 2);

        start = System.nanoTime();
        set.contains(sample);
        long searchTime = System.nanoTime() - start;

        start = System.nanoTime();
        set.remove(sample);
        long removeTime = System.nanoTime() - start;

        System.out.println("\n" + name + " Performance:");
        System.out.println("Add Time: " + addTime + " ns");
        System.out.println("Search Time: " + searchTime + " ns");
        System.out.println("Remove Time: " + removeTime + " ns");
    }

    // Entry point
    public static void main(String[] args) {

        PolicyVaultSystem system = new PolicyVaultSystem();

        List<InsurancePolicy> samplePolicies = Arrays.asList(
                new InsurancePolicy("P101", "Aaditya", LocalDate.now().plusDays(10), "Health", 5000),
                new InsurancePolicy("P102", "Riya", LocalDate.now().plusDays(40), "Auto", 3000),
                new InsurancePolicy("P103", "Karan", LocalDate.now().plusDays(20), "Home", 4500),
                new InsurancePolicy("P101", "Duplicate", LocalDate.now().plusDays(15), "Health", 5200) // Duplicate
        );

        // Adding policies
        samplePolicies.forEach(system::addPolicy);

        System.out.println("\nAll Unique Policies:");
        system.displayAllPolicies();

        System.out.println("\nPolicies Expiring Within 30 Days:");
        system.policiesExpiringSoon(30);

        System.out.println("\nHealth Coverage Policies:");
        system.policiesByCoverage("Health");

        // Performance comparison
        system.comparePerformance(samplePolicies);
    }
}
