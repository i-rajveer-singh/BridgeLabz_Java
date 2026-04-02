package annotation;

// Step 1: Import required packages
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Step 2: Create Custom Annotation
@Retention(RetentionPolicy.RUNTIME)   // Available at runtime
@Target(ElementType.METHOD)           // Can be applied only to methods
@interface MyAnnotation {
    String author();
    String date();
    int version() default 1;          // Default value
}

// Step 3: Use Custom Annotation
class AnnotationDemo {

    @MyAnnotation(author = "Prajwal", date = "03-03-2026", version = 2)
    public void display() {
        System.out.println("Custom Annotation Example");
    }
}

// Step 4: Main Class
public class CustomAnnotationExample {

    public static void main(String[] args) throws Exception {

        AnnotationDemo obj = new AnnotationDemo();
        obj.display();

        // Access annotation using Reflection
        MyAnnotation annotation = obj.getClass()
                .getMethod("display")
                .getAnnotation(MyAnnotation.class);

        System.out.println("\nAnnotation Details:");
        System.out.println("Author: " + annotation.author());
        System.out.println("Date: " + annotation.date());
        System.out.println("Version: " + annotation.version());
    }
}