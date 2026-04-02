package designpattern;

// 1. Subject Interface
interface DataAccess {
    void fetchData();
}

// 2. Real Subject
class RealDataService implements DataAccess {

    public void fetchData() {
        System.out.println("Fetching confidential data...");
    }
}

// 3. Proxy Class
class DataAccessProxy implements DataAccess {

    private String role;
    private RealDataService realService;

    public DataAccessProxy(String role) {
        this.role = role;
    }

    public void fetchData() {
        if (role.equalsIgnoreCase("ADMIN")) {
            realService = new RealDataService();
            realService.fetchData();
        } else {
            System.out.println("Access Denied!");
        }
    }
}

// 4. Main
public class ProxyDemo {
    public static void main(String[] args) {

        DataAccess user = new DataAccessProxy("USER");
        user.fetchData();

        DataAccess admin = new DataAccessProxy("ADMIN");
        admin.fetchData();
    }
}