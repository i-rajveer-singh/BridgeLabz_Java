package designpattern;

// 1. Implementor Interface
interface Color {
    void applyColor();
}

// 2. Concrete Implementations
class Red implements Color {
    public void applyColor() {
        System.out.println("Applying Red Color");
    }
}

class Blue implements Color {
    public void applyColor() {
        System.out.println("Applying Blue Color");
    }
}

// 3. Abstraction
abstract class Shape1 {
    protected Color color;

    protected Shape1(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// 4. Refined Abstractions
class Circle1 extends Shape1 {

    public Circle1(Color color) {
        super(color);
    }

    public void draw() {
        System.out.print("Drawing Circle with ");
        color.applyColor();
    }
}

class Square extends Shape1 {

    public Square(Color color) {
        super(color);
    }

    public void draw() {
        System.out.print("Drawing Square with ");
        color.applyColor();
    }
}

// 5. Main Class
public class BridgeDemo {

    public static void main(String[] args) {

        Shape1 redCircle = new Circle1(new Red());
        redCircle.draw();

        Shape1 blueSquare = new Square(new Blue());
        blueSquare.draw();
    }
}