package designpattern;

// 1. Subsystems
class AuthenticationService {
    public void authenticate(String user) {
        System.out.println("Authenticating " + user);
    }
}

class PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing payment: " + amount);
    }
}

class NotificationService {
    public void sendReceipt() {
        System.out.println("Sending receipt notification");
    }
}

// 2. Facade Class
class OrderFacade {

    private AuthenticationService auth = new AuthenticationService();
    private PaymentGateway payment = new PaymentGateway();
    private NotificationService notify = new NotificationService();

    public void placeOrder(String user, double amount) {
        auth.authenticate(user);
        payment.processPayment(amount);
        notify.sendReceipt();
        System.out.println("Order Completed Successfully");
    }
}

// 3. Main Class
public class FacadeDemo {

    public static void main(String[] args) {

        OrderFacade order = new OrderFacade();
        order.placeOrder("Prajwal", 2500);
    }
}