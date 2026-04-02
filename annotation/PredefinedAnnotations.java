package annotation;

@FunctionalInterface
interface MyFunctionalInterface {
    void display();
}

class Parent {
    @Deprecated
    void oldMethod() {
        System.out.println("This method is deprecated");
    }
}

class Child extends Parent {

    @Override
    void oldMethod() {
        System.out.println("Overridden deprecated method");
    }
}

public class PredefinedAnnotations {

    @SafeVarargs
    public static void printItems(String... items) {
        for (String item : items) {
            System.out.println(item);
        }
    }

    @SuppressWarnings("unchecked")
    public static void suppressExample() {
        java.util.List list = new java.util.ArrayList(); // Raw type warning suppressed
        list.add("Hello");
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {

        // Using Functional Interface with Lambda
        MyFunctionalInterface obj = () ->
                System.out.println("Functional Interface implemented using Lambda");

        obj.display();

        // Using Deprecated and Override
        Child child = new Child();
        child.oldMethod();

        // Using SafeVarargs
        printItems("Java", "Annotations", "Example");

        // Using SuppressWarnings
        suppressExample();
    }
}