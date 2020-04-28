import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        int hours = countHours(firstEmployee,secondEmployee,thirdEmployee,students);
        System.out.println("Time needed: "+hours+"h.");
    }

    private static int countHours(int firstEmployee, int secondEmployee, int thirdEmployee, int students) {
        int hours = 0;
        while (students>0){
           students-=(firstEmployee+secondEmployee+thirdEmployee);
           hours++;
           if (hours%4==0){
               hours++;
           }
        }
        return hours;
    }
}
