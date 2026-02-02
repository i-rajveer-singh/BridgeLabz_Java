package inheritance;

/*
 This program demonstrates multilevel inheritance in an educational course system.
 It models how a basic course evolves into an online and then a paid online course.
 Each subclass adds more specific attributes and functionality.
 The example highlights inheritance across multiple levels.
*/

class BaseCourse {
    String courseName;
    int duration;

    BaseCourse(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayDetails() { // displays basic course details
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// OnlineCourse subclass adding platform details
class OnlineCourseLevel extends BaseCourse {
    String platform;
    boolean isRecorded;

    OnlineCourseLevel(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayDetails() { // displays online course details
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}

// PaidOnlineCourse subclass adding payment details
class PaidOnlineCourseLevel extends OnlineCourseLevel {
    double fee;
    double discount;

    PaidOnlineCourseLevel(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayDetails() { // displays paid online course details
        super.displayDetails();
        System.out.println("Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

// Main class to test multilevel course inheritance
public class CourseHierarchy {

    public static void main(String[] args) { // program execution starts here
        BaseCourse course = new PaidOnlineCourseLevel(
                "Java Programming",
                8,
                "Coursera",
                true,
                5000,
                10
        );

        course.displayDetails();
    }
}

