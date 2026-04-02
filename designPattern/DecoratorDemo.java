package designpattern;

// 1. Component Interface
interface Beverage {
    double cost();
    String description();
}

// 2. Concrete Component
class PlainTea implements Beverage {

    public double cost() {
        return 20.0;
    }

    public String description() {
        return "Plain Tea";
    }
}

// 3. Abstract Decorator
abstract class AddOnDecorator implements Beverage {

    protected Beverage beverage;

    public AddOnDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

// 4. Concrete Decorators
class HoneyAddOn extends AddOnDecorator {

    public HoneyAddOn(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return beverage.cost() + 10;
    }

    public String description() {
        return beverage.description() + " + Honey";
    }
}

class GingerAddOn extends AddOnDecorator {

    public GingerAddOn(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return beverage.cost() + 5;
    }

    public String description() {
        return beverage.description() + " + Ginger";
    }
}

// 5. Main Class
public class DecoratorDemo {

    public static void main(String[] args) {

        Beverage drink = new PlainTea();
        drink = new HoneyAddOn(drink);
        drink = new GingerAddOn(drink);

        System.out.println(drink.description());
        System.out.println("Total Cost: " + drink.cost());
    }
}
