package collections;
/*
 * PolicyMapManager handles insurance policies using HashMap, LinkedHashMap,
 * and TreeMap to demonstrate fast lookup, insertion order, and sorted storage.
 * It supports retrieval, expiry filtering, policyholder search,
 * and automatic removal of expired policies.
 */

import java.util.*;
import java.time.*;

// Represents an insurance policy
class PolicyRecord {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premium;

    public PolicyRecord(String policyNumber, String policyholderName,
                        LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    // Returns policy number
    public String getPolicyNumber() { return policyNumber; }

    // Returns policyholder name
    public String getPolicyholderName() { return policyholderName; }

    // Returns expiry date
    public LocalDate getExpiryDate() { return expiryDate; }

    // Formats policy details
    @Override
    public String toString() {
        return policyNumber + " | " + policyholderName + " | " +
                expiryDate + " | " + coverageType + " | $" + premium;
    }
}

public class PolicyMapManager {

    private Map<String, PolicyRecord> hashMap = new HashMap<>();
    private Map<String, PolicyRecord> linkedMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<PolicyRecord>> treeMap = new TreeMap<>();

    // Adds policy into all maps
    public void addPolicy(PolicyRecord policy) {

        hashMap.put(policy.getPolicyNumber(), policy);
        linkedMap.put(policy.getPolicyNumber(), policy);

        treeMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>())
                .add(policy); // Group by expiry date
    }

    // Retrieves policy by number
    public PolicyRecord getPolicy(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    // Lists policies expiring within next X days
    public void policiesExpiringSoon(int days) {

        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(days);

        treeMap.subMap(today, true, limit, true)
                .values()
                .forEach(list -> list.forEach(System.out::println));
    }

    // Lists policies for a specific policyholder
    public void policiesByHolder(String name) {

        hashMap.values().stream()
                .filter(p -> p.getPolicyholderName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    // Removes expired policies
    public void removeExpiredPolicies() {

        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<String, PolicyRecord>> iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            PolicyRecord policy = iterator.next().getValue();

            if (policy.getExpiryDate().isBefore(today)) {
                iterator.remove(); // Remove from HashMap
                linkedMap.remove(policy.getPolicyNumber());

                List<PolicyRecord> list = treeMap.get(policy.getExpiryDate());
                list.remove(policy);

                if (list.isEmpty())
                    treeMap.remove(policy.getExpiryDate());
            }
        }
    }

    // Displays policies in insertion order
    public void displayInsertionOrder() {
        linkedMap.values().forEach(System.out::println);
    }

    // Entry point
    public static void main(String[] args) {

        PolicyMapManager manager = new PolicyMapManager();

        manager.addPolicy(new PolicyRecord("P1","Aaditya",
                LocalDate.now().plusDays(10),"Health",5000));

        manager.addPolicy(new PolicyRecord("P2","Riya",
                LocalDate.now().plusDays(40),"Auto",3000));

        manager.addPolicy(new PolicyRecord("P3","Aaditya",
                LocalDate.now().minusDays(2),"Home",4500));

        System.out.println("Retrieve P1:");
        System.out.println(manager.getPolicy("P1"));

        System.out.println("\nExpiring within 30 days:");
        manager.policiesExpiringSoon(30);

        System.out.println("\nPolicies for Aaditya:");
        manager.policiesByHolder("Aaditya");

        manager.removeExpiredPolicies();

        System.out.println("\nInsertion Order:");
        manager.displayInsertionOrder();
    }
}
