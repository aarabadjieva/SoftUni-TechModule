import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    public static class Person{
        private String name;
        private String ID;
        private int age;

        public Person(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line  = scanner.nextLine();
        List<Person> persons = new ArrayList<>();
        while (!line.equals("End")){
            String[] input = line.split(" ");
            Person current = new Person(input[0],input[1],Integer.parseInt(input[2]));
            persons.add(current);
            line = scanner.nextLine();
        }
        persons.stream().sorted(Comparator.comparing(e->e.age)).forEach(e->
                System.out.printf("%s with ID: %s is %d years old.%n",e.name,e.ID,e.age));
    }
}
