package generics;
/*
 * IntelliHireScreening demonstrates an AI-driven resume screening system using generics.
 * It processes resumes for multiple job roles like Software Engineer, Data Scientist,
 * and Product Manager with strict type safety. Wildcards enable flexible handling
 * of mixed job roles within the screening pipeline.
 */

import java.util.*;

// Base abstract class for all job roles
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    // Returns role name
    public String getRoleName() {
        return roleName;
    }

    // Ensures each role provides evaluation criteria
    public abstract String evaluateCandidate();
}

// Software Engineer role
class SoftwareEngineer extends JobRole {

    public SoftwareEngineer() {
        super("Software Engineer");
    }

    // Provides evaluation criteria for software engineers
    public String evaluateCandidate() {
        return "Evaluate coding skills, system design, and problem-solving.";
    }
}

// Data Scientist role
class DataScientist extends JobRole {

    public DataScientist() {
        super("Data Scientist");
    }

    // Provides evaluation criteria for data scientists
    public String evaluateCandidate() {
        return "Evaluate statistics, machine learning, and data analysis.";
    }
}

// Product Manager role
class ProductManager extends JobRole {

    public ProductManager() {
        super("Product Manager");
    }

    // Provides evaluation criteria for product managers
    public String evaluateCandidate() {
        return "Evaluate leadership, strategy, and communication.";
    }
}

// Generic Resume class restricted to JobRole
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    // Returns candidate name
    public String getCandidateName() {
        return candidateName;
    }

    // Returns job role
    public T getJobRole() {
        return jobRole;
    }

    // Provides formatted resume summary
    public String getResumeSummary() {
        return candidateName + " applying for " + jobRole.getRoleName();
    }
}

// Screening utility class
class ScreeningPipeline {

    // Generic method to screen a resume dynamically
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println(resume.getResumeSummary());
        System.out.println("Screening Criteria: " + resume.getJobRole().evaluateCandidate());
        System.out.println("Status: Resume forwarded to next round.\n");
    }

    // Wildcard method to display multiple job roles
    public static void displayRoles(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Role: " + role.getRoleName());
        }
    }
}

// Driver class
public class IntelliHireScreening {

    // Entry point of the program
    public static void main(String[] args) {

        Resume<SoftwareEngineer> seResume = new Resume<>("Aaditya", new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>("Riya", new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Karan", new ProductManager());

        System.out.println("=== AI Resume Screening ===\n");

        ScreeningPipeline.screenResume(seResume);
        ScreeningPipeline.screenResume(dsResume);
        ScreeningPipeline.screenResume(pmResume);

        // Demonstrating wildcard usage with multiple roles
        List<JobRole> roles = Arrays.asList(
                new SoftwareEngineer(),
                new DataScientist(),
                new ProductManager()
        );

        System.out.println("=== Available Job Roles ===");
        ScreeningPipeline.displayRoles(roles);
    }
}
