package designpattern;

// 1. User Class
class User {

    // Private fields
    private String name;
    private int age;
    private String email;
    private String phone;

    // 2. Private constructor
    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }

    // 3. Static Inner Builder Class
    public static class Builder {

        private String name;
        private int age;
        private String email;
        private String phone;

        // 4. Setter-like methods
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        // 5. Build method
        public User build() {
            return new User(this);
        }
    }
}


// 6. Main Class
public class BuilderDemo {

    public static void main(String[] args) {

        User user = new User.Builder()
                .setName("Prajwal")
                .setAge(21)
                .setEmail("prajwal@email.com")
                .setPhone("9876543210")
                .build();

        user.display();
    }
}