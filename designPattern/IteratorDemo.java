package designpattern;

// 1. Custom Iterator Interface
interface MyIterator {
    boolean hasNext();
    Object next();
}

// 2. Collection Class
class StudentCollection {

    private String[] students = {"Prajwal", "Amit", "Rohit"};

    public MyIterator getIterator() {
        return new StudentIterator();
    }

    private class StudentIterator implements MyIterator {

        int index = 0;

        public boolean hasNext() {
            return index < students.length;
        }

        public Object next() {
            if (this.hasNext()) {
                return students[index++];
            }
            return null;
        }
    }
}

// 3. Main
public class IteratorDemo {

    public static void main(String[] args) {

        StudentCollection collection = new StudentCollection();
        MyIterator iterator = collection.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}