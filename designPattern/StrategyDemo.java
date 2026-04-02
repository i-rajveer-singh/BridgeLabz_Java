package designpattern;

// 1. Strategy Interface
interface PaymentMethod {
    void pay(double amount);
}

// 2. Concrete Strategies
class CashMode implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}

class CardMode implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

class UpiMode implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

// 3. Context
class PaymentProcessor {

    private PaymentMethod paymentMethod;

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}

// 4. Main
public class StrategyDemo {

    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        processor.setPaymentMethod(new CashMode());
        processor.processPayment(500);

        processor.setPaymentMethod(new CardMode());
        processor.processPayment(1000);
    }
}