package designpattern;

// 1. State Interface
interface TrafficState {
    void handle(TrafficSignal context);
}

// 2. Concrete States
class RedSignal implements TrafficState {
    public void handle(TrafficSignal context) {
        System.out.println("Red Light - Stop");
        context.setState(new GreenSignal());
    }
}

class GreenSignal implements TrafficState {
    public void handle(TrafficSignal context) {
        System.out.println("Green Light - Go");
        context.setState(new YellowSignal());
    }
}

class YellowSignal implements TrafficState {
    public void handle(TrafficSignal context) {
        System.out.println("Yellow Light - Slow Down");
        context.setState(new RedSignal());
    }
}

// 3. Context
class TrafficSignal {

    private TrafficState state;

    public TrafficSignal() {
        state = new RedSignal();
    }

    public void setState(TrafficState state) {
        this.state = state;
    }

    public void change() {
        state.handle(this);
    }
}

// 4. Main
public class StateDemo {

    public static void main(String[] args) {

        TrafficSignal signal = new TrafficSignal();

        signal.change();
        signal.change();
        signal.change();
    }
}