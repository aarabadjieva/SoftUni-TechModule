import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Students {
    public static class Student{
        private String firstName;
        private String lastName;
        private int age;
        private String town;

        public Student(String firstName, String lastName, int age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        while (!line.equals("end")){
            String input[] = line.split(" ");
            Student student = new Student(input[0],input[1],Integer.parseInt(input[2]),input[3]);
            boolean exist = exist(students,student.firstName,student.lastName);
            if (exist){
                Student existing = getExistingStudent(students,student.firstName,student.lastName);
                students.remove(existing);
            }
            students.add(student);
            line = scanner.nextLine();
        }
        String city = scanner.nextLine();
        List<Student> studentsFromCity = students.stream().filter(e->e.town.equals(city)).collect(Collectors.toList());
        for (Student current:studentsFromCity
             ) {
            System.out.printf("%s %s is %d years old%n",current.firstName,current.lastName,current.age);
        }
    }
    private static Student getExistingStudent(List<Student> students,String firstName, String lastName){
        Student existing = null;
        for (Student current:students
             ) {
            if (current.lastName.equals(lastName)&&current.firstName.equals(firstName)){
                existing= current;
            }
        }
        return existing;
    }
    private static boolean exist(List<Student> students, String firstName,String lastName){
        for (Student current:students
             ) {
            if (current.firstName.equals(firstName)&&current.lastName.equals(lastName)){
                return true;
            }
        }
        return false;
    }
}
