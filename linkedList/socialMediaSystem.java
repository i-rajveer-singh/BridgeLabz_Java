package linkedlist;

/*
 * SocialMediaLinkedList manages users and their friend connections
 * using a singly linked list. Each user has a nested linked list
 * storing friend IDs. Supports adding/removing friends, mutual friends,
 * searching users, and counting connections.
 */

import java.util.Scanner;

// Node for Friend List
class FriendNode {
    int friendId;
    FriendNode next; // pointer to next friend

    FriendNode(int id) {
        this.friendId = id;
        this.next = null;
    }
}

// Node representing each user
class User {
    int userId;
    String name;
    int age;
    FriendNode friendHead; // start of friend list
    User next; // pointer to next user

    User(int id, String name, int age) {
        this.userId = id;
        this.name = name;
        this.age = age;
        this.friendHead = null;
        this.next = null;
    }
}

// Linked List class
class SocialMediaLinkedList {

    private User head; // start of user list

    // Add user at end
    public void addUser(int id, String name, int age) {

        User newUser = new User(id, name, age);

        if (head == null) {
            head = newUser;
        } else {
            User temp = head;

            while (temp.next != null) {
                temp = temp.next; // traverse to last user
            }

            temp.next = newUser;
        }

        System.out.println("User added.");
    }

    // Find user by ID
    private User getUser(int id) {

        User temp = head;

        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }

        return null;
    }

    // Add friend connection (bidirectional)
    public void addFriendConnection(int id1, int id2) {

        User u1 = getUser(id1);
        User u2 = getUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        addFriend(u1, id2);
        addFriend(u2, id1); // ensure mutual friendship

        System.out.println("Friend connection added.");
    }

    // Helper to add friend to a user's friend list
    private void addFriend(User user, int friendId) {

        FriendNode newFriend = new FriendNode(friendId);

        if (user.friendHead == null) {
            user.friendHead = newFriend;
            return;
        }

        FriendNode temp = user.friendHead;

        while (temp.next != null) {
            if (temp.friendId == friendId) return; // prevent duplicates
            temp = temp.next;
        }

        if (temp.friendId == friendId) return;

        temp.next = newFriend;
    }

    // Remove friend connection
    public void removeFriendConnection(int id1, int id2) {

        User u1 = getUser(id1);
        User u2 = getUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        removeFriend(u1, id2);
        removeFriend(u2, id1);

        System.out.println("Friend connection removed.");
    }

    // Helper to remove friend from list
    private void removeFriend(User user, int friendId) {

        FriendNode temp = user.friendHead;
        FriendNode prev = null;

        while (temp != null && temp.friendId != friendId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        if (prev == null) {
            user.friendHead = temp.next; // removing first friend
        } else {
            prev.next = temp.next; // bypass node
        }
    }

    // Display friends of a user
    public void displayFriends(int id) {

        User user = getUser(id);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        FriendNode temp = user.friendHead;

        if (temp == null) {
            System.out.println("No friends.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");

        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }

    // Find mutual friends
    public void mutualFriends(int id1, int id2) {

        User u1 = getUser(id1);
        User u2 = getUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        FriendNode f1 = u1.friendHead;
        boolean found = false;

        while (f1 != null) {

            FriendNode f2 = u2.friendHead;

            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.println("Mutual Friend ID: " + f1.friendId);
                    found = true;
                }
                f2 = f2.next;
            }

            f1 = f1.next;
        }

        if (!found)
            System.out.println("No mutual friends.");
    }

    // Search by ID
    public void searchById(int id) {

        User user = getUser(id);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        printUser(user);
    }

    // Search by Name
    public void searchByName(String name) {

        User temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                printUser(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("User not found.");
    }

    // Count friends for each user
    public void countFriends() {

        User temp = head;

        while (temp != null) {

            int count = 0;
            FriendNode f = temp.friendHead;

            while (f != null) {
                count++;
                f = f.next;
            }

            System.out.println(temp.name + " has " + count + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayUsers() {

        User temp = head;

        if (temp == null) {
            System.out.println("No users available.");
            return;
        }

        while (temp != null) {
            printUser(temp);
            temp = temp.next;
        }
    }

    // Helper method to print user
    private void printUser(User u) {
        System.out.println("ID: " + u.userId +
                ", Name: " + u.name +
                ", Age: " + u.age);
    }
}

// Main driver class
public class SocialMediaSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SocialMediaLinkedList list = new SocialMediaLinkedList(); // create user list

        while (true) {

            System.out.println("\n---- Social Media Menu ----");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends");
            System.out.println("5. Mutual Friends");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Count Friends");
            System.out.println("9. Display Users");
            System.out.println("10. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clears buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    list.addUser(id, name, age);
                    break;

                case 2:
                    System.out.print("Enter First User ID: ");
                    int id1 = sc.nextInt();

                    System.out.print("Enter Second User ID: ");
                    int id2 = sc.nextInt();

                    list.addFriendConnection(id1, id2);
                    break;

                case 3:
                    System.out.print("Enter First User ID: ");
                    id1 = sc.nextInt();

                    System.out.print("Enter Second User ID: ");
                    id2 = sc.nextInt();

                    list.removeFriendConnection(id1, id2);
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    list.displayFriends(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter First User ID: ");
                    id1 = sc.nextInt();

                    System.out.print("Enter Second User ID: ");
                    id2 = sc.nextInt();

                    list.mutualFriends(id1, id2);
                    break;

                case 6:
                    System.out.print("Enter User ID: ");
                    list.searchById(sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter Name: ");
                    list.searchByName(sc.nextLine());
                    break;

                case 8:
                    list.countFriends();
                    break;

                case 9:
                    list.displayUsers();
                    break;

                case 10:
                    System.out.println("Exiting program...");
                    sc.close(); // prevents resource leak
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
