package designpattern;

// 1. Shape Interface
interface Shape {
    void draw();
}

// 2. Concrete Classes
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// 3. Factory Class
class ShapeFactory {

    // 4. Factory Method
    public static Shape getShape(String type) {
        if (type == null) return null;

        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }

        return null;
    }
}

// 5. Main Class
public class FactoryMethodDemo {

    public static void main(String[] args) {

        Shape shape1 = ShapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("rectangle");
        shape2.draw();
    }
}
