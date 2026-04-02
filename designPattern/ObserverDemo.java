package designpattern;

import java.util.ArrayList;
import java.util.List;

// 1. Observer Interface
interface Subscriber {
    void update(String news);
}

// 2. Subject Interface
interface NewsPublisher {
    void subscribe(Subscriber s);
    void notifySubscribers();
}

// 3. Concrete Subject
class NewsChannel implements NewsPublisher {

    private List<Subscriber> subscribers = new ArrayList<>();
    private String news;

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void setNews(String news) {
        this.news = news;
        notifySubscribers();
    }

    public void notifySubscribers() {
        for (Subscriber s : subscribers) {
            s.update(news);
        }
    }
}

// 4. Concrete Observer
class MobileUser implements Subscriber {

    private String name;

    public MobileUser(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

// 5. Main
public class ObserverDemo {

    public static void main(String[] args) {

        NewsChannel channel = new NewsChannel();

        Subscriber user1 = new MobileUser("Prajwal");
        Subscriber user2 = new MobileUser("Rahul");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.setNews("New Java Version Released!");
    }
}