import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPoll {
    public static class Person{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] name = scanner.nextLine().split(" ");
            Person person = new Person(name[0],Integer.parseInt(name[1]));
            people.add(person);
        }
        List<Person> over30 = people.stream().sorted(Comparator.comparing(e -> e.name)).filter(e->e.age>30).collect(Collectors.toList());
        for (Person person:over30
             ) {
            System.out.println(person.name+" - "+person.age);
        }
    }
}
