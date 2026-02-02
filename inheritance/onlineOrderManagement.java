package inheritance;

/*
 This program demonstrates multilevel inheritance in an online retail system.
 It models an order lifecycle from placement to shipping and delivery.
 Each subclass adds more specific details to the order.
 The example highlights inheritance across multiple class levels.
*/

class BaseOrder {
    int orderId;
    String orderDate;

    BaseOrder(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() { // returns base order status
        return "Order Placed";
    }
}

// ShippedOrder subclass adding shipment details
class ShippedOrder extends BaseOrder {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() { // returns shipped order status
        return "Order Shipped";
    }
}

// DeliveredOrder subclass adding delivery details
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() { // returns delivered order status
        return "Order Delivered";
    }
}

// Main class to test multilevel inheritance
public class OnlineRetail {

    public static void main(String[] args) { // program execution starts here
        BaseOrder order = new DeliveredOrder(9001, "2026-01-20", "TRK12345", "2026-01-25");
        System.out.println("Order ID: " + order.orderId);
        System.out.println("Order Status: " + order.getOrderStatus());
    }
}
