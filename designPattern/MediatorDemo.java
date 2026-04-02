package designpattern;

import java.util.ArrayList;
import java.util.List;

// 1. Mediator Interface
interface ChatCoordinator {
    void sendMessage(String message, Participant sender);
    void addUser(Participant user);
}

// 2. Concrete Mediator
class GroupChat implements ChatCoordinator {

    private List<Participant> users = new ArrayList<>();

    public void addUser(Participant user) {
        users.add(user);
    }

    public void sendMessage(String message, Participant sender) {
        for (Participant user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}

// 3. Colleague Class
class Participant {

    private String name;
    private ChatCoordinator mediator;

    public Participant(String name, ChatCoordinator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void send(String message) {
        mediator.sendMessage(name + ": " + message, this);
    }

    public void receive(String message) {
        System.out.println(name + " received -> " + message);
    }
}

// 4. Main
public class MediatorDemo {

    public static void main(String[] args) {

        ChatCoordinator chatRoom = new GroupChat();

        Participant user1 = new Participant("Prajwal", chatRoom);
        Participant user2 = new Participant("Amit", chatRoom);

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);

        user1.send("Hello Everyone!");
    }
}