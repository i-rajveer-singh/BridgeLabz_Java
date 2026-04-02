package annotation;

public class Person {

    private int id;
    private String name;
    private int age;
    private String city;

    // Constructor
    public Person(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + city;
    }
}