import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static class Student{
        private String firstName;
        private String lastName;
        private double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Student current = new Student(input[0],input[1],Double.parseDouble(input[2]));
            students.add(current);
        }
        students.stream().sorted((e1,e2)->{
            int compare = Double.compare(e2.grade,e1.grade);
            return compare;
        }).forEach(e-> System.out.printf("%s %s: %.2f%n",e.firstName,e.lastName,e.grade));
    }
}
