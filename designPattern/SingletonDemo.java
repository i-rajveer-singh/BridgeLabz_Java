package designpattern;

// 1. Singleton Class
class Logger {

    // 2. Private static instance
    private static Logger instance;

    // 3. Private constructor
    private Logger() {
        System.out.println("Logger Instance Created");
    }

    // 4. Public static method to get instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // 5. Business method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}


// 6. Main Class (Test Class)
public class SingletonDemo {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("First Message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second Message");

        // Verify both references are same
        System.out.println(logger1 == logger2); // Should print true
    }
}
