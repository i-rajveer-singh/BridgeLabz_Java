package designpattern;

// 1. Command Interface
interface ActionCommand {
    void execute();
}

// 2. Receiver
class FanDevice {
    public void turnOn() {
        System.out.println("Fan turned ON");
    }

    public void turnOff() {
        System.out.println("Fan turned OFF");
    }
}

// 3. Concrete Commands
class FanOnCommand implements ActionCommand {

    private FanDevice fan;

    public FanOnCommand(FanDevice fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.turnOn();
    }
}

class FanOffCommand implements ActionCommand {

    private FanDevice fan;

    public FanOffCommand(FanDevice fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.turnOff();
    }
}

// 4. Invoker
class SmartRemote {
    private ActionCommand command;

    public void setCommand(ActionCommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// 5. Main
public class CommandDemo {
    public static void main(String[] args) {

        FanDevice fan = new FanDevice();
        SmartRemote remote = new SmartRemote();

        remote.setCommand(new FanOnCommand(fan));
        remote.pressButton();

        remote.setCommand(new FanOffCommand(fan));
        remote.pressButton();
    }
}