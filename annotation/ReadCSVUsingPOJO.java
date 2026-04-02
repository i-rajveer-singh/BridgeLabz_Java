package annotation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVUsingPOJO {

    public static void main(String[] args) {

        String filePath = "src/annotation/data.csv";  // adjust if needed

        List<Person> personList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                int id = Integer.parseInt(values[0]);
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                String city = values[3];

                Person person = new Person(id, name, age, city);
                personList.add(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print All Objects
        System.out.println("CSV Data as POJO Objects:\n");
        for (Person p : personList) {
            System.out.println(p);
        }
    }
}