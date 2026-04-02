package designpattern;

// 1. Expression Interface
interface ArithmeticExpression {
    int interpret();
}

// 2. Terminal Expression
class NumberValue implements ArithmeticExpression {

    private int number;

    public NumberValue(int number) {
        this.number = number;
    }

    public int interpret() {
        return number;
    }
}

// 3. Non-Terminal Expressions
class AdditionExpression implements ArithmeticExpression {

    private ArithmeticExpression left, right;

    public AdditionExpression(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class SubtractionExpression implements ArithmeticExpression {

    private ArithmeticExpression left, right;

    public SubtractionExpression(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

// 4. Main
public class InterpreterDemo {

    public static void main(String[] args) {

        ArithmeticExpression expr =
                new AdditionExpression(
                        new NumberValue(10),
                        new SubtractionExpression(
                                new NumberValue(5),
                                new NumberValue(2)
                        )
                );

        System.out.println("Result: " + expr.interpret());
    }
}