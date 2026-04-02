package designpattern;

// 1. Abstract Handler
abstract class ApprovalHandler {

    protected ApprovalHandler nextHandler;

    public void setNext(ApprovalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void approveRequest(int amount);
}

// 2. Concrete Handlers
class Supervisor extends ApprovalHandler {

    void approveRequest(int amount) {
        if (amount <= 10000) {
            System.out.println("Supervisor approved request.");
        } else if (nextHandler != null) {
            nextHandler.approveRequest(amount);
        }
    }
}

class Director extends ApprovalHandler {

    void approveRequest(int amount) {
        if (amount <= 50000) {
            System.out.println("Director approved request.");
        } else if (nextHandler != null) {
            nextHandler.approveRequest(amount);
        }
    }
}

class CEOHandler extends ApprovalHandler {

    void approveRequest(int amount) {
        System.out.println("CEO approved request.");
    }
}

// 3. Main
public class ChainDemo {

    public static void main(String[] args) {

        ApprovalHandler supervisor = new Supervisor();
        ApprovalHandler director = new Director();
        ApprovalHandler ceo = new CEOHandler();

        supervisor.setNext(director);
        director.setNext(ceo);

        supervisor.approveRequest(60000);
    }
}