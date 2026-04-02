package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// ================= META ANNOTATION EXAMPLE =================

// Repeatable container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface Roles {
    Role[] value();
}

// Custom annotation with Meta-Annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented     // ✅ ADD THIS
@interface Roles {
    Role[] value();
}

// Parent class using annotation
@Role("Admin")
class Parent {
}

// Child class (inherits annotation because of @Inherited)
class Child extends Parent {

    @Role("Developer")
    public void display() {
        System.out.println("Inside Child display method");
    }
}

// ================= MAIN CLASS =================

public class MetaAnnotationsExample {

    public static void main(String[] args) throws Exception {

        Child child = new Child();
        child.display();

        // Checking inherited annotation
        System.out.println("\nClass Level Annotations (Inherited):");
        Role[] classRoles = child.getClass().getAnnotationsByType(Role.class);
        for (Role r : classRoles) {
            System.out.println("Role: " + r.value());
        }

        // Checking method annotation
        System.out.println("\nMethod Level Annotations:");
        Method method = child.getClass().getMethod("display");
        Role[] methodRoles = method.getAnnotationsByType(Role.class);
        for (Role r : methodRoles) {
            System.out.println("Role: " + r.value());
        }
    }
}